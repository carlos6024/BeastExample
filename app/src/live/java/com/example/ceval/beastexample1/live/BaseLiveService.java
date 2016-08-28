package com.example.ceval.beastexample1.live;

import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.otto.Bus;

public class BaseLiveService {
    protected Bus bus;
    private BeastApplication application;
    protected final DatabaseReference mDatabase;

    public BaseLiveService(BeastApplication application) {
        this.application = application;
        bus  = application.getBus();
        bus.register(this);
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }
}
