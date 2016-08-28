package com.example.ceval.beastexample1.views.RushViews;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.ceval.beastexample1.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RushFooterHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.footer_rush_fragment_facebook)
    ImageView faceBookImage;

    @Bind(R.id.footer_rush_fragment_snapChat)
    ImageView snapChatImage;

    @Bind(R.id.footer_rush_fragment_instaGram)
    ImageView instaImage;

    @Bind(R.id.footer_rush_fragment_twitter)
    ImageView twitterImage;

    public RushFooterHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);


        faceBookImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                try{
                    view.getContext().getPackageManager().getPackageInfo("com.facebook.katana",0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/605083229565089"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/officialdjkhaled/"));
                }
                view.getContext().startActivity(intent);
            }
        });



        instaImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                try{
                    view.getContext().getPackageManager().getPackageInfo("com.instagram.android",0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_u/djkhaled"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/djkhaled/?hl=en"));
                }
                view.getContext().startActivity(intent);
            }
        });



        twitterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                try{
                    view.getContext().getPackageManager().getPackageInfo("com.twitter.android",0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=27673684"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (PackageManager.NameNotFoundException e) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/djkhaled"));

                }
                view.getContext().startActivity(intent);
            }
        });

        snapChatImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://snapchat.com/add/" + "djkhaled305"));
                view.getContext().startActivity(intent);
            }
        });
    }

    public void populate(Context context){
        Picasso.with(context).load("http://i50.photobucket.com/albums/f315/carlos6024/faceBookLogo_zps5ehpqnng.png").into(faceBookImage);

        Picasso.with(context).load(" http://i50.photobucket.com/albums/f315/carlos6024/snapChat_logo_zpsjzwi8hpr.png").into(snapChatImage);

        Picasso.with(context).load("http://i50.photobucket.com/albums/f315/carlos6024/insta_logo_zpshg6xmz7g.jpg").into(instaImage);

        Picasso.with(context).load("https://dl.dropboxusercontent.com/s/jbtx0tbvi2t3v67/twitter%20logo.jpg?dl=0").into(twitterImage);
    }

}
