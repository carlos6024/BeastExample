package com.example.ceval.beastexample1.views.AboutUsViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.activites.BaseActivity;
import com.example.ceval.beastexample1.entites.EventInformationCard;
import com.example.ceval.beastexample1.views.MeetABroViews.BrotherViewHolder;

import java.util.ArrayList;

public class AboutUsRecyclerAdapter extends RecyclerView.Adapter {




    //>>Header<<//

    //>>List Header<<//
    //>>Community Service List<<//

    //>>List Header<<//  //<<<<<<<<
    //>>Brother List<<//

    //>>List Header<<//
    //>>Social List<<//



    private final int VIEW_TYPE_MAIN_HEADER = 1;
    private final int VIEW_TYPE_SERVICE_CARDS = 2;
    private final int VIEW_TYPE_BROTHERHOOD_CARDS = 3;
    private final int VIEW_TYPE_SOCIAL_CARDS = 4;
    private final int VIEW_TYPE_LIST_HEADER =5;



    private ArrayList<EventInformationCard> communityCards;
    private ArrayList<EventInformationCard> brotherHoodCards;
    private ArrayList<EventInformationCard> socialCards;


    private BaseActivity activity;
    private LayoutInflater inflater;
    private AboutUsListener listener;

    public AboutUsRecyclerAdapter(BaseActivity activity, AboutUsListener listener) {
        this.activity = activity;
        this.listener = listener;
        inflater = activity.getLayoutInflater();
        communityCards = new ArrayList<>();
        brotherHoodCards = new ArrayList<>();
        socialCards = new ArrayList<>();
    }

    public ArrayList<EventInformationCard> getCommunityCards() {
        return communityCards;
    }

    public ArrayList<EventInformationCard> getBrotherHoodCards() {
        return brotherHoodCards;
    }

    public ArrayList<EventInformationCard> getSocialCards() {
        return socialCards;
    }

    @Override
    public int getItemViewType(int position) {
        if(position ==0){
            return VIEW_TYPE_MAIN_HEADER;
        }

        position --;


        if(communityCards.size()>0){
            if (position ==0){
                return VIEW_TYPE_LIST_HEADER;
            }

            position --;

            if (position<communityCards.size()){
                return VIEW_TYPE_SERVICE_CARDS;
            }

            position -= communityCards.size();
        }

        if(brotherHoodCards.size()>0){
            if (position == 0){
                return VIEW_TYPE_LIST_HEADER;
            }

            position --;

            if(position<brotherHoodCards.size()){
                return VIEW_TYPE_BROTHERHOOD_CARDS;
            }

            position -= brotherHoodCards.size();
        }


        if(socialCards.size()>0){
            if(position ==0){
                return VIEW_TYPE_LIST_HEADER;
            }
            position --;

            if(position<socialCards.size()){
                return VIEW_TYPE_SOCIAL_CARDS;
            }

            position -= socialCards.size();
        }

        throw new IllegalArgumentException("We are being asked fo a viewType at position " + position + " although we are at the " +
                "end of our list");
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View eventCardView = inflater.inflate(R.layout.list_event_card, parent, false);
        final View listHeaderView = inflater.inflate(R.layout.simple_header, parent, false);


        if (viewType == VIEW_TYPE_MAIN_HEADER) {
            return new AboutUsHeaderHolder(inflater, parent);
        } else if (viewType == VIEW_TYPE_SERVICE_CARDS) {
            final CommunityServiceHolder communityServiceHolder = new CommunityServiceHolder(eventCardView);
            communityServiceHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventInformationCard informationCard = (EventInformationCard) communityServiceHolder.itemView.getTag();
                    listener.onEvenCardClicked(informationCard);

                }
            });
            return communityServiceHolder;
        }

            else if (viewType == VIEW_TYPE_BROTHERHOOD_CARDS) {
                final BrotherHoodHolder brotherHoodHolder = new BrotherHoodHolder(eventCardView);
                brotherHoodHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EventInformationCard informationCard = (EventInformationCard) brotherHoodHolder.itemView.getTag();
                        listener.onEvenCardClicked(informationCard);

                    }
                });

            return brotherHoodHolder;
            }

        else if (viewType == VIEW_TYPE_SOCIAL_CARDS) {
            final SocialHolder socialHolder = new SocialHolder(eventCardView);
            socialHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventInformationCard informationCard = (EventInformationCard) socialHolder.itemView.getTag();
                    listener.onEvenCardClicked(informationCard);

                }
            });

            return socialHolder;
        }

        else if (viewType == VIEW_TYPE_LIST_HEADER){
            return new AboutUsListHeaderHolder(listHeaderView);
        }

        throw  new IllegalArgumentException(viewType + " is not supported in this adapter");

    }




    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof AboutUsHeaderHolder){
            AboutUsHeaderHolder holder1 = (AboutUsHeaderHolder) holder;
        }

        if (holder instanceof CommunityServiceHolder){
            position --;
            if (communityCards.size()>0){
                position --;
            }
            EventInformationCard eventInformationCard = communityCards.get(position);
            ((CommunityServiceHolder) holder).populate(activity,eventInformationCard);
        }

        if (holder instanceof BrotherHoodHolder){
            position --;

            if(communityCards.size()>0){
                position --;
                position -= communityCards.size();
            }

            if (brotherHoodCards.size()>0){
                position --;
            }

            EventInformationCard eventInformationCard = brotherHoodCards.get(position);
            ((BrotherHoodHolder) holder).populate(activity,eventInformationCard);
        }

        if (holder instanceof SocialHolder){
            position --;

            if(communityCards.size()>0){
                position --;
                position -= communityCards.size();
            }

            if (brotherHoodCards.size()>0){
                position --;
                position -= brotherHoodCards.size();
            }

            if (socialCards.size()>0){
                position --;
            }

            EventInformationCard eventInformationCard = socialCards.get(position);
            ((SocialHolder) holder).populate(activity,eventInformationCard);

        }

        if (holder instanceof AboutUsListHeaderHolder){

            AboutUsListHeaderHolder aboutUsListHeaderHolder =(AboutUsListHeaderHolder) holder;
            int servicePosition = 1;
            int brotherHoodPosition = servicePosition + communityCards.size() +1;
            int socialPosition = brotherHoodPosition + brotherHoodCards.size() +1;


            if(position == servicePosition){
                aboutUsListHeaderHolder.populate("Community Service Events");
            }

            if (position == brotherHoodPosition){
                aboutUsListHeaderHolder.populate("BrotherHood Events");
            }


            if (position == socialPosition){
                aboutUsListHeaderHolder.populate("Social Events");
            }
        }




    }

    @Override
    public int getItemCount() {
        int count = 1;

        if (communityCards.size()>0){
            count += 1 + communityCards.size();
        }

        if (socialCards.size()>0){
            count += 1 + socialCards.size();
        }

        if(brotherHoodCards.size()>0){
            count += 1+ brotherHoodCards.size();
        }

        return count;
    }


    public interface AboutUsListener{
        void onEvenCardClicked(EventInformationCard eventInformationCard);
    }
}
