package com.example.ceval.beastexample1.views.RushViews;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.entites.RushEvent;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RushEventViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.list_rush_event_name)
    TextView rushEventName;

    @Bind(R.id.list_rush_event_location)
    TextView rushEventLocation;

    @Bind(R.id.list_rush_event_date)
    TextView rushEventDate;

    @Bind(R.id.list_rush_event_time)
    TextView rushEventTime;

    public RushEventViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }


    public void populate(RushEvent rushEvent){
        itemView.setTag(rushEvent);
        rushEventName.setText(rushEvent.getEventName());
        rushEventLocation.setText(rushEvent.getEventLocation());
        rushEventDate.setText(rushEvent.getEventDate());
        rushEventTime.setText(rushEvent.getEventTime());
    }

}
