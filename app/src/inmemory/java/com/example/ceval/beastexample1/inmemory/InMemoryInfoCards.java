package com.example.ceval.beastexample1.inmemory;

import com.example.ceval.beastexample1.entites.EventInformationCard;
import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.example.ceval.beastexample1.services.InformationCardService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class InMemoryInfoCards extends BaseInMemoryService {
    public InMemoryInfoCards(BeastApplication application) {
        super(application);
    }


    @Subscribe
    public void getServiceCards(InformationCardService.SearchCommunityCardsRequest request){
        InformationCardService.SearchCommunityCardsResponse response = new InformationCardService.SearchCommunityCardsResponse();
        response.communityCards = new ArrayList<>();

        response.communityCards.add(new EventInformationCard(
                0,
                "Community Service Event 0",
                "Service Event Description for Event 0",
                "http://www.gravatar.com/avatar/" + 0 + "?d=identicon",
                false,""));


        response.communityCards.add(new EventInformationCard(
                1,
                "Community Service Event 1",
                "Service Event Description for Event 1",
                "http://www.gravatar.com/avatar/" + 1 + "?d=identicon",
                true,"-3bMERyIUWo"));


        bus.post(response);
    }


    @Subscribe
    public void getBrotherCards(InformationCardService.SearchBrotherhoodRequest request){
        InformationCardService.SearchBrotherHoodResponse response = new InformationCardService.SearchBrotherHoodResponse();



        response.brotherHooodCards = new ArrayList<>();

        response.brotherHooodCards.add(new EventInformationCard(
                2,
                "BrotherHood Event 1",
                "Description for Event 2",
                "http://www.gravatar.com/avatar/" + 3 + "?d=identicon",
                false,""));

        response.brotherHooodCards.add(new EventInformationCard(
                3,
                "BrotherHood Event 2",
                "Description for Event 2",
                "http://www.gravatar.com/avatar/" + 4 + "?d=identicon",
                true,"DvE7O3bLQgE"));


        bus.post(response);
    }



    @Subscribe
    public void getSocialCards(InformationCardService.SearchSocialRequest request){
        InformationCardService.SearchSocialReponse response = new InformationCardService.SearchSocialReponse();



        response.socialCards = new ArrayList<>();

        response.socialCards.add(new EventInformationCard(
                4,
                "Social  Event 1",
                "Description for Social Event 1",
                "http://www.gravatar.com/avatar/" + 5 + "?d=identicon",
                false,""));

        response.socialCards.add(new EventInformationCard(
                5,
                "Social Event 2",
                "Description for Social Event 2",
                "http://www.gravatar.com/avatar/" + 6 + "?d=identicon",
                true,"ADQQUOqbuRI"));


        bus.post(response);
    }






}



