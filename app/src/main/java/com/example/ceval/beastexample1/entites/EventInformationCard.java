package com.example.ceval.beastexample1.entites;

public class EventInformationCard {
    private int eventId;
    private String eventTitle;
    private String eventCardDescripton;
    private String eventImage;
    private Boolean isVideo;
    private String youtubeEnding;


    public EventInformationCard(int eventId, String eventTitle, String eventCardDescripton, String eventImage, Boolean isVideo, String youtubeEnding) {
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.eventCardDescripton = eventCardDescripton;
        this.eventImage = eventImage;
        this.isVideo = isVideo;
        this.youtubeEnding = youtubeEnding;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventCardDescripton() {
        return eventCardDescripton;
    }

    public String getEventImage() {
        return eventImage;
    }

    public Boolean getVideo() {
        return isVideo;
    }

    public String getYoutubeEnding() {
        return youtubeEnding;
    }
}
