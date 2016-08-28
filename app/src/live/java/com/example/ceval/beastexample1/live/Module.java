package com.example.ceval.beastexample1.live;

import com.example.ceval.beastexample1.infrastructure.BeastApplication;

public class Module {

    public static void register(BeastApplication application){
        new LiveBrotherService(application);
        new LiveInforCardService(application);
        new LivePhotoService(application);
        new LiveRushService(application);

    }
}
