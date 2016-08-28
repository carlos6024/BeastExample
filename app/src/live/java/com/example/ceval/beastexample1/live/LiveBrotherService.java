package com.example.ceval.beastexample1.live;

import com.example.ceval.beastexample1.entites.Brother;
import com.example.ceval.beastexample1.entites.FireBaseEntites.FireBaseBrother;
import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.example.ceval.beastexample1.services.BrotherService;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class LiveBrotherService extends BaseLiveService {
    public LiveBrotherService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void loadBRothers(BrotherService.SearchBrothersRequest request) {
        final BrotherService.SearchBrothersResponse response = new BrotherService.SearchBrothersResponse();
        response.brothers = new ArrayList<>();
        Firebase reference = new Firebase(request.firebaseUrl);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index =0;
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    FireBaseBrother fireBaseBrother = dataSnapshot1.getValue(FireBaseBrother.class);
                    Brother brother = new Brother(
                            index,
                            fireBaseBrother.getName(),
                            fireBaseBrother.getWhy(),
                            fireBaseBrother.getPicture(),
                            fireBaseBrother.getMajor(),
                            fireBaseBrother.getCross(),
                            fireBaseBrother.getFact()
                    );
                    response.brothers.add(brother);
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
