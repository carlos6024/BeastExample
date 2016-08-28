package com.example.ceval.beastexample1.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.entites.RushEvent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MapsActivity extends BaseActivity {
    private GoogleApiClient mClient;
    private GoogleMap mMap;
    private RushEvent rushEvent;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);
        rushEvent = getIntent().getParcelableExtra(RUSH_EVENT_INFO);
        rushName.setText(rushEvent.getEventName());
        rushDescripton.setText(rushEvent.getEventDescription());
        rushLocation.setText(rushEvent.getEventLocation());
        rushTime.setText(rushEvent.getEventTime());
        rushDate.setText(rushEvent.getEventDate());


        mClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(@Nullable Bundle bundle) {
                        updateUI();
                    }

                    @Override
                    public void onConnectionSuspended(int i) {

                    }
                }).build();


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.activity_map_map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap= googleMap;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mClient.connect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mClient.disconnect();
    }

    private void updateUI(){
        LatLng rushEventPoint = new LatLng(
                rushEvent.getEventLatitude(),rushEvent.getEventLongitude()
        );
        MarkerOptions rushEventMarker = new MarkerOptions()
                .position(rushEventPoint)
                .title("Rush Event Location")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

        mMap.clear();
        mMap.addMarker(rushEventMarker);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rushEventPoint,15));
    }

    public static Intent newIntent(Context context, RushEvent rushEvent){
        Intent intent = new Intent(context,MapsActivity.class);
        intent.putExtra(RUSH_EVENT_INFO,rushEvent);
        return intent;
    }
}
