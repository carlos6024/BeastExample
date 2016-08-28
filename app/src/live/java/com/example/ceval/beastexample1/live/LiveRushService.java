package com.example.ceval.beastexample1.live;

import com.example.ceval.beastexample1.entites.FireBaseEntites.FireBaseRushEvent;
import com.example.ceval.beastexample1.entites.RushEvent;
import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.example.ceval.beastexample1.services.RushService;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class LiveRushService extends BaseLiveService {
    public LiveRushService(BeastApplication application) {
        super(application);
    }
    @Subscribe
    public void getServiceRushEvents(RushService.SearchServiceEventsRequest request){
        final RushService.SearchServiceEventResponse response = new RushService.SearchServiceEventResponse();
        response.serviceRushEvents = new ArrayList<>();
        Firebase reference = new Firebase(request.fireBaseUrl);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index =0;

                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    FireBaseRushEvent fireBaseRushEvent = dataSnapshot1.getValue(FireBaseRushEvent.class);
                    RushEvent rushEvent = new RushEvent(
                            index,
                            fireBaseRushEvent.getName(),
                            fireBaseRushEvent.getDate(),
                            fireBaseRushEvent.getTime(),
                            fireBaseRushEvent.getLocation(),
                            fireBaseRushEvent.getLatitiude(),
                            fireBaseRushEvent.getLongitude(),
                            fireBaseRushEvent.isCampus(),
                            fireBaseRushEvent.getDescription()
                    );
                    response.serviceRushEvents.add(rushEvent);
                    index ++;
                }

                bus.post(response);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }


    @Subscribe
    public void getSocialEvents(RushService.SearchSoialEventRequest request){
        final RushService.SearcSocialEventResponse response = new RushService.SearcSocialEventResponse();
        response.socialsrushEvents = new ArrayList<>();
        Firebase reference = new Firebase(request.firebaseUrl);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index =0;

                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    FireBaseRushEvent fireBaseRushEvent = dataSnapshot1.getValue(FireBaseRushEvent.class);
                    RushEvent rushEvent = new RushEvent(
                            index,
                            fireBaseRushEvent.getName(),
                            fireBaseRushEvent.getDate(),
                            fireBaseRushEvent.getTime(),
                            fireBaseRushEvent.getLocation(),
                            fireBaseRushEvent.getLatitiude(),
                            fireBaseRushEvent.getLongitude(),
                            fireBaseRushEvent.isCampus(),
                            fireBaseRushEvent.getDescription()
                    );


                    response.socialsrushEvents.add(rushEvent);
                    index ++;
                }

                bus.post(response);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
