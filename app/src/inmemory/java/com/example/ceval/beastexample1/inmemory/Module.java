package com.example.ceval.beastexample1.inmemory;

import com.example.ceval.beastexample1.infrastructure.BeastApplication;

public class Module {
    public static void register(BeastApplication application){
        new InMememoryBrotherService(application);
        new InMemoryInfoCards(application);
        new InMemoryPhotoService(application);
        new InMemeoryRushService(application);
    }
}
