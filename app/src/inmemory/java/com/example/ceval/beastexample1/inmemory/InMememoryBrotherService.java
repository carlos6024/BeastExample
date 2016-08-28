package com.example.ceval.beastexample1.inmemory;

import com.example.ceval.beastexample1.entites.Brother;
import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.example.ceval.beastexample1.services.BrotherService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class InMememoryBrotherService extends BaseInMemoryService {
    public InMememoryBrotherService(BeastApplication application) {
        super(application);
    }


    @Subscribe
    public void loadBRothers(BrotherService.SearchBrothersRequest request) {
        BrotherService.SearchBrothersResponse response = new BrotherService.SearchBrothersResponse();
        response.brothers = new ArrayList<>();

        for (int i = 0; i < 32; i++) {
            response.brothers.add(new Brother(
                    i,
                    "Brother " + i,
                    "I joined because I wanted to",
                    "http://www.gravatar.com/avatar/" + i + "?d=identicon",
                    "Mechincal Engineering",
                    "Spring 2013",
                    "I love Android!!!!"
            ));
        }

        bus.post(response);
    }
}
