package com.example.ceval.beastexample1.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ceval.beastexample1.fragments.AboutUsFragment;
import com.example.ceval.beastexample1.fragments.MeetABroFragment;
import com.example.ceval.beastexample1.fragments.RushFragment;

public class MainActivityAdapter extends FragmentStatePagerAdapter {

    public MainActivityAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment returnFragment;
        switch (position){
            case 0:
                returnFragment = AboutUsFragment.newInstance();
                break;
            case 1:
                returnFragment = MeetABroFragment.newInstance();
                break;
            case 2:
                returnFragment = RushFragment.newInstance();
                break;
            default:
                return null;
        }
        return returnFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title;
        switch (position){
            case 0:
                title = "About Us";
                break;
            case 1:
                title = "Meet A Bro";
                break;
            case 2:
                title = "Rush";
                break;
            default:
                return null;
        }
        return title;
    }
}
