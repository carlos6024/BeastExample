package com.example.ceval.beastexample1.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.entites.RushEvent;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CampusMapAcstivity extends BaseActivity{
    public static final String RUSH_EVENT_INFO = "RUSH_EVENT_INFO";

    @Bind(R.id.activity_map_rush_name)
    TextView rushName;

    @Bind(R.id.activity_map_rush_description)
    TextView rushDescripton;

    @Bind(R.id.activity_map_rush_location)
    TextView rushLocation;

    @Bind(R.id.activity_map_rush_time)
    TextView rushTime;

    @Bind(R.id.activity_map_rush_date)
    TextView rushDate;

    @Bind(R.id.activity_campus_map_progressBar)
    ProgressBar progressBar;

    @Bind(R.id.activity_campus_map_webView)
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_map);
        ButterKnife.bind(this);

        RushEvent rushEvent = getIntent().getParcelableExtra(RUSH_EVENT_INFO);
        rushName.setText(rushEvent.getEventName());
        rushDescripton.setText(rushEvent.getEventDescription());
        rushLocation.setText(rushEvent.getEventLocation());
        rushTime.setText(rushEvent.getEventTime());
        rushDate.setText(rushEvent.getEventDate());

        String googleDocs = "http://docs.google.com/gview?embedded=true&url=";

        progressBar.setMax(100);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if(newProgress ==100){
                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);

                }
            }
        });


        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });

        webView.loadUrl( googleDocs + "http://www.asu.edu/map/pdf/asu_map_tempe_2015.pdf");

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
       if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()){
           webView.goBack();
           return true;
       }
        return super.onKeyDown(keyCode, event);
    }
    public static Intent newIntent(Context context, RushEvent rushEvent){
        Intent intent = new Intent(context,CampusMapAcstivity.class);
        intent.putExtra(RUSH_EVENT_INFO,rushEvent);
        return intent;
    }
}
