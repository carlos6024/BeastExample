package com.example.ceval.beastexample1.views.RushViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.activites.BaseActivity;
import com.example.ceval.beastexample1.entites.RushEvent;

import java.util.ArrayList;
import java.util.List;




////>>>>Header>>//////

//>>>List>>>///////

//>>>>>Footer<<</////

public class RushEventAdapter extends RecyclerView.Adapter {

    private final int VIEW_TYPE_LIST_HEADER =1;
    public static final int VIEW_TYPE_EXPANDABLE_LIST_HEADER =2;
    public static final int VIEW_TYPE_EXPANDABLE_LIST_CHILD =3;
    private final int VIEW_TYPE_LIST_FOOTER  =4;


    private List<Item> data;
    private BaseActivity activity;
    private LayoutInflater inflater;
    private RushEventListener listener;

    public RushEventAdapter(BaseActivity activity, RushEventListener listener) {
        this.activity = activity;
        this.listener = listener;
        inflater = activity.getLayoutInflater();
        data = new ArrayList<>();
    }




    public List<Item> getData() {
        return data;
    }

    @Override
    public int getItemViewType(int position) {
        if (position ==0){
            return VIEW_TYPE_LIST_HEADER;
        }

        position --;

        if(position<data.size()){
            return data.get(position).type;
        }

        position -= data.size();


        if (position<data.size()){
            return VIEW_TYPE_LIST_FOOTER;
        }

        position --;

        throw new IllegalArgumentException("We are being asked fo a viewType at position " + position + " although we are at the " +
                "end of our list");
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View expandableHeaderView = inflater.inflate(R.layout.list_rush_expandable_header,parent,false);
        final View rushEventView = inflater.inflate(R.layout.list_rush_events,parent,false);
        View rushHeaderView = inflater.inflate(R.layout.header_fragment_rush,parent,false);
        View rushFooterView = inflater.inflate(R.layout.footer_rush_fragment,parent,false);


        switch (viewType){
            case VIEW_TYPE_LIST_HEADER:
                return new RushHeaderHolder(rushHeaderView);


            case VIEW_TYPE_EXPANDABLE_LIST_CHILD:
                final RushEventViewHolder rushEventViewHolder = new RushEventViewHolder(rushEventView);
                rushEventViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RushEvent rushEvent = (RushEvent) rushEventViewHolder.itemView.getTag();
                        listener.onRushEventClicked(rushEvent);
                    }
                });
                return rushEventViewHolder;


            case VIEW_TYPE_EXPANDABLE_LIST_HEADER:
                return new RushExpandableHeaderHolder(expandableHeaderView);

            case VIEW_TYPE_LIST_FOOTER:
                return new RushFooterHolder(rushFooterView);
        }
        throw  new IllegalArgumentException(viewType + " is not supported in this adapter");
    }








    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RushExpandableHeaderHolder){
            position --;

            final Item item = data.get(position);
            final RushExpandableHeaderHolder itemController = (RushExpandableHeaderHolder) holder;

            itemController.referalItem = item;
            itemController.headerTitle.setText(item.test);

            if (item.invisibleChildrlen == null){
                itemController.buttonToggle.setImageResource(R.mipmap.close);
            } else{
                itemController.buttonToggle.setImageResource(R.mipmap.plus);
            }



            itemController.backgroundView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(item.invisibleChildrlen ==null){
                        item.invisibleChildrlen = new ArrayList<>();
                        int count =0;
                        int position = data.indexOf(itemController.referalItem);
                        while (data.size()>position +1 && data.get(position +1).type == VIEW_TYPE_EXPANDABLE_LIST_CHILD){
                            item.invisibleChildrlen.add(data.remove(position+1));
                            count ++;
                        }

                        notifyItemRangeRemoved(position +1,count);
                        itemController.buttonToggle.setImageResource(R.mipmap.plus);
                    } else{
                        int position = data.indexOf(itemController.referalItem);
                        int index = position +1;

                        for(Item item1: item.invisibleChildrlen){
                            data.add(index,item1);
                            index ++;
                        }

                        notifyItemRangeInserted(position +1, index -position -1);
                        itemController.buttonToggle.setImageResource(R.mipmap.close);
                        item.invisibleChildrlen = null;
                    }
                }
            });
        } else if (holder instanceof  RushEventViewHolder){
            position --;
            RushEventViewHolder holder1 = (RushEventViewHolder) holder;
            holder1.populate(data.get(position).rushEvent);
        } else if (holder instanceof  RushHeaderHolder){
            RushHeaderHolder headerHolder = (RushHeaderHolder) holder;
        } else if (holder instanceof RushFooterHolder){
            ((RushFooterHolder) holder).populate(activity);
        }
    }


    @Override
    public int getItemCount() {
        int count = 2;

        if (data.size()>0){
            count += data.size();
        }

        return count;
    }

    public interface RushEventListener{
        void onRushEventClicked(RushEvent rushEvent);
    }
}
