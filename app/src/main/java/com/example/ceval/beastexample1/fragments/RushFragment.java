package com.example.ceval.beastexample1.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.activites.BaseActivity;
import com.example.ceval.beastexample1.activites.CampusMapAcstivity;
import com.example.ceval.beastexample1.activites.MapsActivity;
import com.example.ceval.beastexample1.entites.RushEvent;
import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.example.ceval.beastexample1.services.RushService;
import com.example.ceval.beastexample1.views.RushViews.Item;
import com.example.ceval.beastexample1.views.RushViews.RushEventAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class RushFragment extends BaseFragment implements RushEventAdapter.RushEventListener{

    private RushEventAdapter adapter;

    private ArrayList<RushEvent> socialEvents;
    private ArrayList<RushEvent> communityEvents;

    private Item social;
    private Item community;

    private RecyclerView recyclerView;

    public static RushFragment newInstance(){
        return new RushFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rush,container,false);
        adapter = new RushEventAdapter((BaseActivity) getActivity(), this);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_rush_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        socialEvents = new ArrayList<>();
        communityEvents = new ArrayList<>();


        List<Item> data = adapter.getData();

        social = new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_HEADER,"Social Events");
        social.invisibleChildrlen = new ArrayList<>();

        community = new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_HEADER,"Community Events");
        community.invisibleChildrlen = new ArrayList<>();

        bus.post(new RushService.SearchServiceEventsRequest(BeastApplication.FIREBASE_RUSH_SERVICE_URL));
        bus.post(new RushService.SearchSoialEventRequest(BeastApplication.FIREBASE_RUSH_SOCIAL_URL));

        setUpAdapter();

        data.add(community);
        data.add(social);
        return rootView;
    }



    private void setUpAdapter() {
        if (isAdded()) {
            recyclerView.setAdapter(adapter);
        }
    }


    @Subscribe
    public void getServiceEvents(RushService.SearchServiceEventResponse response){
        communityEvents.clear();
        communityEvents.addAll(response.serviceRushEvents);
        for(RushEvent rushEvent:communityEvents){
            community.invisibleChildrlen.add(new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_CHILD,rushEvent));
        }
    }


    @Subscribe
    public void getSocialEvents(RushService.SearcSocialEventResponse response){
        socialEvents.clear();
        socialEvents.addAll(response.socialsrushEvents);
        for(RushEvent rushEvent:socialEvents){
            social.invisibleChildrlen.add(new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_CHILD,rushEvent));
        }
    }

    @Override
    public void onRushEventClicked(RushEvent rushEvent) {
        if(!rushEvent.isAtAsu()){
            Intent intent = MapsActivity.newIntent(getActivity(),rushEvent);
            startActivity(intent);
        } else{
            Intent intent = CampusMapAcstivity.newIntent(getActivity(),rushEvent);
            startActivity(intent);
        }
    }
}
