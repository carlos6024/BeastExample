package com.example.ceval.beastexample1.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.activites.BaseActivity;
import com.example.ceval.beastexample1.activites.BrotherPagerActivity;
import com.example.ceval.beastexample1.entites.Brother;
import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.example.ceval.beastexample1.services.BrotherService;
import com.example.ceval.beastexample1.views.MeetABroViews.BrotherAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class MeetABroFragment extends BaseFragment implements BrotherAdapter.onBrotherClickedListener {

    private final String LOG_TAG = MeetABroFragment.class.getSimpleName();


    private ArrayList<Brother> brothers;
    private RecyclerView recyclerView;
    private BrotherAdapter adapter;


    public static MeetABroFragment newInstance() {
        return new MeetABroFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_meet_a_bro, container, false);
        adapter = new BrotherAdapter(this, (BaseActivity) getActivity());
        brothers = adapter.getBrothers();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_meet_a_bro_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        setUpAdapter();
        bus.post(new BrotherService.SearchBrothersRequest(BeastApplication.FIREBASE_BROTHER_URL));
        return rootView;
    }


    private void setUpAdapter() {
        if (isAdded()) {
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onBrotherClicked(Brother brother) {
        Intent intent = BrotherPagerActivity.newIntent(getActivity(),brother);
        startActivity(intent);
    }


    @Subscribe
    public void onBrothersLoaded(BrotherService.SearchBrothersResponse response) {
        int oldBrotherLength = brothers.size();

        if(oldBrotherLength ==0){
            brothers.clear();
            adapter.notifyItemRangeRemoved(0,oldBrotherLength);
            brothers.addAll(response.brothers);
            adapter.notifyItemRangeChanged(0,brothers.size());

        }
    }

}

