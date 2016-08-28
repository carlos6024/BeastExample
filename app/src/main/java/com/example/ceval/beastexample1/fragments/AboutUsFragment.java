package com.example.ceval.beastexample1.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.activites.BaseActivity;
import com.example.ceval.beastexample1.activites.EventPhotoPagerActivity;
import com.example.ceval.beastexample1.activites.YouTubePlayerActivity;
import com.example.ceval.beastexample1.entites.EventInformationCard;
import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.example.ceval.beastexample1.services.InformationCardService;
import com.example.ceval.beastexample1.views.AboutUsViews.AboutUsRecyclerAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class AboutUsFragment extends BaseFragment implements AboutUsRecyclerAdapter.AboutUsListener {
    private ArrayList<EventInformationCard> serviceCards;
    private ArrayList<EventInformationCard> brotherHoodCards;
    private ArrayList<EventInformationCard> socialCards;


    private RecyclerView recyclerView;
    private AboutUsRecyclerAdapter adapter;




    public static AboutUsFragment newInstance(){
        return new AboutUsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_about_us,container,false);
        adapter = new AboutUsRecyclerAdapter((BaseActivity) getActivity(),this);

        serviceCards = adapter.getCommunityCards();
        brotherHoodCards = adapter.getBrotherHoodCards();
        socialCards = adapter.getSocialCards();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_about_us_recyclerView);
        setUpAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        bus.post(new InformationCardService.SearchCommunityCardsRequest(BeastApplication.FIREBASE_INFORMATION_CARDS_COMMUNITY));
        bus.post(new InformationCardService.SearchBrotherhoodRequest(BeastApplication.FIREBASE_INFORMATION_CARDS_BROTHERHOOD));
        bus.post(new InformationCardService.SearchSocialRequest(BeastApplication.FIREBASE_INFORMATION_CARDS_SOCIALS));
        return rootView;
    }


    private void setUpAdapter() {
        if (isAdded()) {
            recyclerView.setAdapter(adapter);
        }
    }



    @Subscribe
    public void getServiceCards(InformationCardService.SearchCommunityCardsResponse response){

        int oldCardLength = serviceCards.size();

        if(oldCardLength ==0){
            serviceCards.clear();
            adapter.notifyItemRangeRemoved(0,oldCardLength);
            serviceCards.addAll(response.communityCards);
            adapter.notifyItemRangeChanged(0,serviceCards.size());

        }
    }


    @Subscribe
    public void getBrotherHoodCard(InformationCardService.SearchBrotherHoodResponse response){


        int oldCardLength = brotherHoodCards.size();

        if(oldCardLength ==0){
            brotherHoodCards.clear();
            adapter.notifyItemRangeRemoved(0,oldCardLength);
            brotherHoodCards.addAll(response.brotherHooodCards);
            adapter.notifyItemRangeChanged(0,brotherHoodCards.size());

        }

    }


    @Subscribe
    public void getSocialCards(InformationCardService.SearchSocialReponse response){

        int oldCardLength = socialCards.size();

        if(oldCardLength ==0){
            socialCards.clear();
            adapter.notifyItemRangeRemoved(0,oldCardLength);
            socialCards.addAll(response.socialCards);
            adapter.notifyItemRangeChanged(0,socialCards.size());

        }
    }

    @Override
    public void onEvenCardClicked(EventInformationCard eventInformationCard) {
        if (!eventInformationCard.getVideo()){
            Intent intent = EventPhotoPagerActivity.newIntent(getActivity(),eventInformationCard);
            startActivity(intent);
        } else{
            Intent intent = YouTubePlayerActivity.newInstance(getActivity(),eventInformationCard);
            startActivity(intent);
        }
    }
}
