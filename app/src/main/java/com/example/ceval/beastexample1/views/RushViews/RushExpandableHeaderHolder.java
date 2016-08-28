package com.example.ceval.beastexample1.views.RushViews;


import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ceval.beastexample1.R;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RushExpandableHeaderHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.list_rush_expandable_header_background)
    View backgroundView;

    @Bind(R.id.list_rush_expandable_header_title)
    TextView headerTitle;


    @Bind(R.id.list_rush_expandable_header_buttonToggle)
    ImageView buttonToggle;

    public Item referalItem;


    public RushExpandableHeaderHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
