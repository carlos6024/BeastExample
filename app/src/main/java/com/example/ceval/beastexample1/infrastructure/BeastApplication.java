package com.example.ceval.beastexample1.infrastructure;

import android.app.Application;

import com.example.ceval.beastexample1.live.Module;
import com.firebase.client.Firebase;
import com.squareup.otto.Bus;

public class BeastApplication extends Application {


    public static final String YOUTUBE_KEY = "AIzaSyCqvBFoc9CXM48H0DZU5l6LzevwNtNDBFc";

    public static final String FIREBASE_BROTHER_URL = "https://beastexample1-220d8.firebaseio.com/data/brothers";


    public static final String FIREBASE_EVENT_PHOTO_BROTHERHOOD_URL = "https://beastexample1-220d8.firebaseio.com/data/eventPhotos/brotherhood";

    public static final String FIREBASE_EVENT_PHOTO_COMMUNITY_URL = "https://beastexample1-220d8.firebaseio.com/data/eventPhotos/community";

    public static final String FIREBASE_EVENT_PHOTO_SOCIAL_URL = "hhttps://beastexample1-220d8.firebaseio.com/data/eventPhotos/socials";



    public static final String FIREBASE_INFORMATION_CARDS_BROTHERHOOD = "https://beastexample1-220d8.firebaseio.com/data/infoCards/brotherhood";

    public static final String FIREBASE_INFORMATION_CARDS_COMMUNITY= "https://beastexample1-220d8.firebaseio.com/data/infoCards/community";

    public static final String FIREBASE_INFORMATION_CARDS_SOCIALS = "https://beastexample1-220d8.firebaseio.com/data/infoCards/socials";


    public static final String FIREBASE_RUSH_SERVICE_URL = "https://beastexample1-220d8.firebaseio.com/data/rushEvents/service";

    public static final String FIREBASE_RUSH_SOCIAL_URL = "https://beastexample1-220d8.firebaseio.com/data/rushEvents/socials";


    private Bus bus;

    public BeastApplication() {
        bus = new Bus();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Module.register(this);
        Firebase.setAndroidContext(this);
    }

    public Bus getBus() {
        return bus;
    }
}
