package com.example.ceval.beastexample1.views.AboutUsViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.entites.EventInformationCard;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BrotherHoodHolder extends RecyclerView.ViewHolder{

    @Bind(R.id.list_event_card_eventName)
    TextView eventName;

    @Bind(R.id.list_event_card_progressBar)
    ProgressBar eventProgressBar;

    @Bind(R.id.list_event_card_eventType)
    ImageView eventType;

    @Bind(R.id.list_event_card_cardPicture)
    ImageView eventPicture;

    @Bind(R.id.list_event_card_eventDescription)
    TextView eventDescription;


    public BrotherHoodHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(Context context, EventInformationCard eventInformationCard){
        itemView.setTag(eventInformationCard);

        eventName.setText(eventInformationCard.getEventTitle());
        eventDescription.setText(eventInformationCard.getEventCardDescripton());

        if(!eventInformationCard.getVideo()){
            eventType.setImageResource(R.mipmap.camera);
        } else{
            eventType.setImageResource(R.mipmap.video);
        }

        Picasso.with(context).load(eventInformationCard.getEventImage())
                .fit()
                .centerCrop()
                .into(eventPicture, new Callback() {
                    @Override
                    public void onSuccess() {
                        eventProgressBar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onError() {

                    }
                });






    }



}
