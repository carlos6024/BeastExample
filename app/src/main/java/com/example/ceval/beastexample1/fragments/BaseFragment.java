package com.example.ceval.beastexample1.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.squareup.otto.Bus;

public class BaseFragment extends Fragment {
    protected BeastApplication application;
    protected Bus bus;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (BeastApplication) getActivity().getApplication();
        bus = application.getBus();
        bus.register(this);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}
