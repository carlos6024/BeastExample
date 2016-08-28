package com.example.ceval.beastexample1.inmemory;

import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.squareup.otto.Bus;

public class BaseInMemoryService {
    protected final Bus bus;
    protected final BeastApplication application;

    public BaseInMemoryService(BeastApplication application) {
        this.application = application;
        this.bus = application.getBus();
        bus.register(this);
    }

}
