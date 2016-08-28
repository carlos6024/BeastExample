package com.example.ceval.beastexample1.inmemory;

import com.example.ceval.beastexample1.entites.RushEvent;
import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.example.ceval.beastexample1.services.RushService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class InMemeoryRushService extends BaseInMemoryService {
    public InMemeoryRushService(BeastApplication application) {
        super(application);
    }


    @Subscribe
    public void getServiceRushEvents(RushService.SearchServiceEventsRequest request){
        RushService.SearchServiceEventResponse response = new RushService.SearchServiceEventResponse();
        response.serviceRushEvents = new ArrayList<>();


        response.serviceRushEvents.add(new RushEvent(
                0,
                "Service Event 1",
                "8/27/2016",
                "8:00pm",
                "MU 202",
                2.0,2.0,
                true,
                "This is the first rush service event of the semester! Come and join us."
        ));

        bus.post(response);
    }


    @Subscribe
    public void getSocialEvents(RushService.SearchSoialEventRequest request){
        RushService.SearcSocialEventResponse response = new RushService.SearcSocialEventResponse();
        response.socialsrushEvents = new ArrayList<>();


        response.socialsrushEvents.add(new RushEvent(
                0,
                "Social Event 1",
                "8/28/2016",
                "8:00pm",
                "721 S Mill Ave, Tempe, AZ 85281",
                33.422606,-111.939653,
                false,
                "This is the first rush social event of the semester! Come and join us."
        ));

        bus.post(response);
    }
}
