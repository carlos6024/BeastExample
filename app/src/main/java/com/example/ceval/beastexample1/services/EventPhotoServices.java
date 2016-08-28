package com.example.ceval.beastexample1.services;

import com.example.ceval.beastexample1.entites.EventPhoto;

import java.util.List;

public class EventPhotoServices {
    public EventPhotoServices(){
    }

    public static class SearchCommunityPhotosRequest{
        public String fireBaseUrl;

        public SearchCommunityPhotosRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }


    public static class SearchCommunityPhotosResponse{
        public List<EventPhoto> communityPhotos;
    }


    public static class SearchBrotherHoodPhotosRequest{
        public String fireBaseUrl;

        public SearchBrotherHoodPhotosRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchBrotherhoodResponse{
        public List<EventPhoto> brotherHoodPhotos;
    }


    public static class SearchSocialRequest{
        public String fireBaseUrl;

        public SearchSocialRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }


    public static class SearchSocialResonse{
        public List<EventPhoto> socialPhotos;
    }








}
