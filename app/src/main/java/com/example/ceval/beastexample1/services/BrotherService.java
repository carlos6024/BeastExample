package com.example.ceval.beastexample1.services;

import com.example.ceval.beastexample1.entites.Brother;

import java.util.List;

public class BrotherService {
    private BrotherService(){
    }

    public static class SearchBrothersRequest{
        public String firebaseUrl;

        public SearchBrothersRequest(String firebaseUrl) {
            this.firebaseUrl = firebaseUrl;
        }
    }


    public static class SearchBrothersResponse{
        public List<Brother> brothers;
    }


}


