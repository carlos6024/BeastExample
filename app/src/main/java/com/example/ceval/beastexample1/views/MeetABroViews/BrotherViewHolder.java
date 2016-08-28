package com.example.ceval.beastexample1.views.MeetABroViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.entites.Brother;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BrotherViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.list_brothers_displayPicture)
    ImageView brotherImage;

    @Bind(R.id.list_brothers_displayProgressBar)
    ProgressBar progressBar;


    public BrotherViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(Context context,Brother brother){
        itemView.setTag(brother);

        Picasso.with(context).load(brother.getBrotherPicture())
                .fit()
                .centerCrop()
                .into(brotherImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }

}
