package com.example.ceval.beastexample1.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.squareup.otto.Bus;

public class BaseActivity extends AppCompatActivity {
    protected BeastApplication application;
    protected Bus bus;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (BeastApplication) getApplication();
        bus = application.getBus();
        bus.register(this);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}
