package com.example.ceval.beastexample1.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.entites.EventInformationCard;
import com.example.ceval.beastexample1.entites.EventPhoto;
import com.example.ceval.beastexample1.fragments.EventPhotoFragment;
import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.example.ceval.beastexample1.services.EventPhotoServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EventPhotoPagerActivity extends BaseActivity {
    private ArrayList<EventPhoto> mEventPhotos;


    @Bind(R.id.photo_viewPager)
    ViewPager photoPager;


    public static final String EXTRA_CARD_INFO = "EXTRA_CARD_INFO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_photo_pager_actvity);
        ButterKnife.bind(this);
        mEventPhotos = new ArrayList<>();

        int CardIndex = getIntent().getIntExtra(EXTRA_CARD_INFO,0);

        switch (CardIndex){
            case 0:
                bus.post( new EventPhotoServices.SearchCommunityPhotosRequest(BeastApplication.FIREBASE_EVENT_PHOTO_COMMUNITY_URL));
                break;

            case 2:
                bus.post(new EventPhotoServices.SearchBrotherHoodPhotosRequest(BeastApplication.FIREBASE_EVENT_PHOTO_BROTHERHOOD_URL));
                break;

            case 4:
                bus.post(new EventPhotoServices.SearchSocialRequest(BeastApplication.FIREBASE_EVENT_PHOTO_SOCIAL_URL));
                break;
        }

        photoPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                EventPhoto eventPhoto = mEventPhotos.get(position);
                return EventPhotoFragment.newInstance(eventPhoto);
            }

            @Override
            public int getCount() {
                return mEventPhotos.size();
            }
        });
    }



    @Subscribe
    public void getServicePhotos(EventPhotoServices.SearchCommunityPhotosResponse response){
        mEventPhotos.clear();
        mEventPhotos.addAll(response.communityPhotos);
        photoPager.getAdapter().notifyDataSetChanged();
    }


    @Subscribe
    public void getBrotherhoodPhotos(EventPhotoServices.SearchBrotherhoodResponse response){
        mEventPhotos.clear();
        mEventPhotos.addAll(response.brotherHoodPhotos);
        photoPager.getAdapter().notifyDataSetChanged();
    }


    @Subscribe
    public void getServicePhotos(EventPhotoServices.SearchSocialResonse response){
        mEventPhotos.clear();
        mEventPhotos.addAll(response.socialPhotos);
        photoPager.getAdapter().notifyDataSetChanged();
    }


    public static Intent newIntent(Context context, EventInformationCard eventInformationCard){
        Intent intent = new Intent(context,EventPhotoPagerActivity.class);
        intent.putExtra(EXTRA_CARD_INFO,eventInformationCard.getEventId());
        return intent;
    }
}
