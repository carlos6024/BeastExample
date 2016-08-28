package com.example.ceval.beastexample1.live;

import com.example.ceval.beastexample1.entites.EventInformationCard;
import com.example.ceval.beastexample1.entites.FireBaseEntites.FireBaseInfoCard;
import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.example.ceval.beastexample1.services.InformationCardService;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class LiveInforCardService extends BaseLiveService {
    public LiveInforCardService(BeastApplication application) {
        super(application);
    }


    @Subscribe
    public void getServiceCards(InformationCardService.SearchCommunityCardsRequest request){
        final InformationCardService.SearchCommunityCardsResponse response = new InformationCardService.SearchCommunityCardsResponse();
        response.communityCards = new ArrayList<>();

        Firebase reference = new Firebase(request.fireBaseUrl);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index =0;
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    FireBaseInfoCard fireBaseInfoCard = dataSnapshot1.getValue(FireBaseInfoCard.class);
                    EventInformationCard eventInformationCard = new EventInformationCard(
                            index,
                            fireBaseInfoCard.getTitle(),
                            fireBaseInfoCard.getDescription(),
                            fireBaseInfoCard.getPicture(),
                            fireBaseInfoCard.isVideo(),
                            fireBaseInfoCard.getUrl()
                    );
                    response.communityCards.add(eventInformationCard);
                }
                bus.post(response);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }


    @Subscribe
    public void getBrotherCards(InformationCardService.SearchBrotherhoodRequest request){
        final InformationCardService.SearchBrotherHoodResponse response = new InformationCardService.SearchBrotherHoodResponse();
        response.brotherHooodCards = new ArrayList<>();
        Firebase reference = new Firebase(request.fireBaseUrl);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index =2;
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    FireBaseInfoCard fireBaseInfoCard = dataSnapshot1.getValue(FireBaseInfoCard.class);
                    EventInformationCard eventInformationCard = new EventInformationCard(
                            index,
                            fireBaseInfoCard.getTitle(),
                            fireBaseInfoCard.getDescription(),
                            fireBaseInfoCard.getPicture(),
                            fireBaseInfoCard.isVideo(),
                            fireBaseInfoCard.getUrl()
                    );
                    response.brotherHooodCards.add(eventInformationCard);
                }
                bus.post(response);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }



    @Subscribe
    public void getSocialCards(InformationCardService.SearchSocialRequest request){
        final InformationCardService.SearchSocialReponse response = new InformationCardService.SearchSocialReponse();
        response.socialCards = new ArrayList<>();

        Firebase reference = new Firebase(request.fireBaseUrl);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int index =4;
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    FireBaseInfoCard fireBaseInfoCard = dataSnapshot1.getValue(FireBaseInfoCard.class);
                    EventInformationCard eventInformationCard = new EventInformationCard(
                            index,
                            fireBaseInfoCard.getTitle(),
                            fireBaseInfoCard.getDescription(),
                            fireBaseInfoCard.getPicture(),
                            fireBaseInfoCard.isVideo(),
                            fireBaseInfoCard.getUrl()
                    );
                    response.socialCards.add(eventInformationCard);
                }
                bus.post(response);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }


}










