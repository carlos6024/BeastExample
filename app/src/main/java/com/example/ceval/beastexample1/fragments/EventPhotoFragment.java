package com.example.ceval.beastexample1.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.entites.EventPhoto;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EventPhotoFragment extends BaseFragment {
    @Bind(R.id.fragment_event_photo_Image)
    ImageView eventPhotoView;

    @Bind(R.id.fragment_event_photo_progressBar)
    ProgressBar eventPhotoProgressBar;


    public final static String EVENT_PHOTO_INFO = "EVENT_PHOTO_INFO";
    private String photoUrl;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photoUrl = getArguments().getString(EVENT_PHOTO_INFO);
    }


    public static EventPhotoFragment newInstance(EventPhoto eventPhoto){
        Bundle arugments = new Bundle();
        arugments.putString(EVENT_PHOTO_INFO,eventPhoto.getEventphotoUrl());
        EventPhotoFragment eventPhotoFragment = new EventPhotoFragment();
        eventPhotoFragment.setArguments(arugments);
        return eventPhotoFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_photo,container,false);
        ButterKnife.bind(this,rootView);

        Picasso.with(getActivity()).load(photoUrl)
                .fit()
                .centerCrop()
                .into(eventPhotoView, new Callback() {
                    @Override
                    public void onSuccess() {
                        eventPhotoProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });

        return rootView;

    }
}
