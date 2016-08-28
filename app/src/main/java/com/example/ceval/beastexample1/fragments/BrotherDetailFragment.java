package com.example.ceval.beastexample1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.entites.Brother;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


import butterknife.Bind;
import butterknife.ButterKnife;

public class BrotherDetailFragment extends BaseFragment{
    private Brother brother;
    private static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";

    @Bind(R.id.fragment_details_brothers_brotherName)
    TextView brotherName;

    @Bind(R.id.fragment_details_brothers_brotherMajor)
    TextView brotherMajor;

    @Bind(R.id.fragment_details_brothers_brotherImage)
    ImageView brotherImage;

    @Bind(R.id.fragment_details_brothers_whyJoin)
    TextView brotherWhyJoined;

    @Bind(R.id.fragment_details_brothers_ProgressBar)
    ProgressBar brotherProgressBar;

    @Bind(R.id.fragment_details_brothersCross)
    TextView brotherCrossed;

    @Bind(R.id.fragment_details_brothers_funFact)
    TextView brotherFunFact;


    public static BrotherDetailFragment newInstance(Brother brother){
        Bundle arguments = new Bundle();
        arguments.putParcelable(BROTHER_EXTRA_INFO,brother);
        BrotherDetailFragment brotherDetailFragment = new BrotherDetailFragment();
        brotherDetailFragment.setArguments(arguments);
        return brotherDetailFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        brother = getArguments().getParcelable(BROTHER_EXTRA_INFO);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_details_brother,container,false);
        ButterKnife.bind(this,rootView);
        brotherName.setText(brother.getBrotherName());
        brotherMajor.setText(getString(R.string.major_intro,brother.getBrotherMajor()));
        brotherWhyJoined.setText(brother.getWhyJoin());
        brotherCrossed.setText(getString(R.string.crosee_semester_intro,brother.getBrotherCrossSemester()));
        brotherFunFact.setText(getString(R.string.fun_fact_intro,brother.getBrotherFunFact()));


        Picasso.with(getActivity()).load(brother.getBrotherPicture())
                .fit()
                .centerCrop()
                .into(brotherImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        brotherProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
        return rootView;
    }
}
