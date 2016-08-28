package com.example.ceval.beastexample1.services;

import com.example.ceval.beastexample1.entites.RushEvent;

import java.util.List;

public class RushService {
    private RushService(){
    }

    public static class SearchServiceEventsRequest {
        public String fireBaseUrl;

        public SearchServiceEventsRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }


    public static class SearchServiceEventResponse{
        public List<RushEvent> serviceRushEvents;
    }


    public static class SearchSoialEventRequest {
        public String firebaseUrl;

        public SearchSoialEventRequest(String firebaseUrl) {
            this.firebaseUrl = firebaseUrl;
        }
    }

    public static class SearcSocialEventResponse{
        public List<RushEvent> socialsrushEvents;
    }
}
