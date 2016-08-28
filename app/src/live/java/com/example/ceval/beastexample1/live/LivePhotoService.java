package com.example.ceval.beastexample1.live;

import com.example.ceval.beastexample1.entites.EventInformationCard;
import com.example.ceval.beastexample1.entites.EventPhoto;
import com.example.ceval.beastexample1.entites.FireBaseEntites.FireBaseEventPhoto;
import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.example.ceval.beastexample1.services.EventPhotoServices;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class LivePhotoService extends BaseLiveService {
    public LivePhotoService(BeastApplication application) {
        super(application);
    }


    @Subscribe
    public void getCommunityPhotos(EventPhotoServices.SearchCommunityPhotosRequest request){
        final EventPhotoServices.SearchCommunityPhotosResponse response = new EventPhotoServices.SearchCommunityPhotosResponse();
        response.communityPhotos = new ArrayList<>();

        Firebase reference = new Firebase(request.fireBaseUrl);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    FireBaseEventPhoto fireBaseEventPhoto = dataSnapshot1.getValue(FireBaseEventPhoto.class);
                    response.communityPhotos.add(new EventPhoto(
                            fireBaseEventPhoto.getUrl()
                    ));

                    bus.post(response);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }


    @Subscribe
    public void getBrotherhoodPhotos(EventPhotoServices.SearchBrotherHoodPhotosRequest request){
        final EventPhotoServices.SearchBrotherhoodResponse response = new EventPhotoServices.SearchBrotherhoodResponse();
        response.brotherHoodPhotos = new ArrayList<>();


        Firebase reference = new Firebase(request.fireBaseUrl);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    FireBaseEventPhoto fireBaseEventPhoto = dataSnapshot1.getValue(FireBaseEventPhoto.class);
                    response.brotherHoodPhotos.add(new EventPhoto(
                            fireBaseEventPhoto.getUrl()
                    ));

                    bus.post(response);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }



    @Subscribe
    public void getSocialPhotos(EventPhotoServices.SearchSocialRequest request){
        final EventPhotoServices.SearchSocialResonse response = new EventPhotoServices.SearchSocialResonse();
        response.socialPhotos = new ArrayList<>();


        Firebase reference = new Firebase(request.fireBaseUrl);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    FireBaseEventPhoto fireBaseEventPhoto = dataSnapshot1.getValue(FireBaseEventPhoto.class);
                    response.socialPhotos.add(new EventPhoto(
                            fireBaseEventPhoto.getUrl()
                    ));

                    bus.post(response);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }



}

