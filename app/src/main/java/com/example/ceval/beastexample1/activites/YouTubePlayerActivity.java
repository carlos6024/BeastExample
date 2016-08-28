package com.example.ceval.beastexample1.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.entites.EventInformationCard;
import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubePlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private String videoUrl;
    public final static String EXTRA_VIDEO_INFO = "EXTRA_VIDEO_INFO";


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_youtube);
        videoUrl = getIntent().getStringExtra(EXTRA_VIDEO_INFO);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.activity_youtube_player_view);
        youTubePlayerView.initialize(BeastApplication.YOUTUBE_KEY,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(videoUrl);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    public static Intent newInstance(Context context, EventInformationCard eventInformationCard){
        Intent intent = new Intent(context,YouTubePlayerActivity.class);
        intent.putExtra(EXTRA_VIDEO_INFO,eventInformationCard.getYoutubeEnding());
        return intent;
    }
}
