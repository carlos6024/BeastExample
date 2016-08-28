package com.example.ceval.beastexample1.services;

import com.example.ceval.beastexample1.entites.EventInformationCard;

import java.util.List;

public class InformationCardService {
    private InformationCardService(){
    }






    public static class SearchCommunityCardsRequest{
        public String fireBaseUrl;

        public SearchCommunityCardsRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchCommunityCardsResponse{
        public List<EventInformationCard> communityCards;
    }







    public static class SearchBrotherhoodRequest{
        public String fireBaseUrl;

        public SearchBrotherhoodRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchBrotherHoodResponse{
        public List<EventInformationCard> brotherHooodCards;
    }





    public static class SearchSocialRequest{
        public String fireBaseUrl;

        public SearchSocialRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }


    public static class SearchSocialReponse{
        public List<EventInformationCard> socialCards;
    }


}
