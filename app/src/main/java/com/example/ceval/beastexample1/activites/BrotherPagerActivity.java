package com.example.ceval.beastexample1.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.entites.Brother;
import com.example.ceval.beastexample1.fragments.BrotherDetailFragment;
import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.example.ceval.beastexample1.services.BrotherService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BrotherPagerActivity extends BaseActivity {

    private ArrayList<Brother> brothers;

    @Bind(R.id.activity_brother_pager_Pager)
    ViewPager brotherViewPager;

    private static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brother_pager);
        ButterKnife.bind(this);
        brothers = new ArrayList<>();
        bus.post(new BrotherService.SearchBrothersRequest(BeastApplication.FIREBASE_BROTHER_URL));
        brotherViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Brother brother = brothers.get(position);
                return BrotherDetailFragment.newInstance(brother);
            }

            @Override
            public int getCount() {
                return brothers.size();
            }
        });

    }


    @Subscribe
    public void onBrothersLoaded(BrotherService.SearchBrothersResponse response){
        brothers.clear();
        brothers.addAll(response.brothers);
        brotherViewPager.getAdapter().notifyDataSetChanged();

        Brother brother = getIntent().getParcelableExtra(BROTHER_EXTRA_INFO);
        int brotherId = brother.getBrotherId();

        for(int i =0; i<brothers.size();i++){
            if(brothers.get(i).getBrotherId() == brotherId){
                brotherViewPager.setCurrentItem(i);
                break;
            }
        }

    }


    public static Intent newIntent(Context context,Brother brother){
        Intent intent = new Intent(context,BrotherPagerActivity.class);
        intent.putExtra(BROTHER_EXTRA_INFO,brother);
        return intent;
    }
}
