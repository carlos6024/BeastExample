package com.example.ceval.beastexample1.activites;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.views.MainActivityAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.activity_main_viewPager)
    ViewPager mainViewPager;

    @Bind(R.id.activity_tab_layout)
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MainActivityAdapter adapter = new MainActivityAdapter(getSupportFragmentManager());
        mainViewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(mainViewPager);
    }
}
