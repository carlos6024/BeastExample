package com.example.ceval.beastexample1.views.AboutUsViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ceval.beastexample1.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AboutUsListHeaderHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.simple_header_textView)
    TextView listHeader;
    public AboutUsListHeaderHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(String header){
        listHeader.setText(header);
    }







}
