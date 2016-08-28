package com.example.ceval.beastexample1.inmemory;

import com.example.ceval.beastexample1.entites.EventPhoto;
import com.example.ceval.beastexample1.infrastructure.BeastApplication;
import com.example.ceval.beastexample1.services.EventPhotoServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class InMemoryPhotoService extends BaseInMemoryService {
    public InMemoryPhotoService(BeastApplication application) {
        super(application);
    }



    @Subscribe
    public void getCommunityPhotos(EventPhotoServices.SearchCommunityPhotosRequest request){
        EventPhotoServices.SearchCommunityPhotosResponse response = new EventPhotoServices.SearchCommunityPhotosResponse();
        response.communityPhotos = new ArrayList<>();

        response.communityPhotos.add(new EventPhoto("http://www.gravatar.com/avatar/" + 30 + "?d=identicon"));
        response.communityPhotos.add(new EventPhoto("http://www.gravatar.com/avatar/" + 31 + "?d=identicon"));
        response.communityPhotos.add(new EventPhoto("http://www.gravatar.com/avatar/" + 32 + "?d=identicon"));

        bus.post(response);

    }


    @Subscribe
    public void getBrotherhoodPhotos(EventPhotoServices.SearchBrotherHoodPhotosRequest request){
        EventPhotoServices.SearchBrotherhoodResponse response = new EventPhotoServices.SearchBrotherhoodResponse();
        response.brotherHoodPhotos = new ArrayList<>();

        response.brotherHoodPhotos.add(new EventPhoto("http://www.gravatar.com/avatar/" + 33 + "?d=identicon"));
        response.brotherHoodPhotos.add(new EventPhoto("http://www.gravatar.com/avatar/" + 34 + "?d=identicon"));
        response.brotherHoodPhotos.add(new EventPhoto("http://www.gravatar.com/avatar/" + 35 + "?d=identicon"));

        bus.post(response);

    }



    @Subscribe
    public void getSocialPhotos(EventPhotoServices.SearchSocialRequest request){
        EventPhotoServices.SearchSocialResonse response = new EventPhotoServices.SearchSocialResonse();
        response.socialPhotos = new ArrayList<>();

        response.socialPhotos.add(new EventPhoto("http://www.gravatar.com/avatar/" + 36 + "?d=identicon"));
        response.socialPhotos.add(new EventPhoto("http://www.gravatar.com/avatar/" + 37 + "?d=identicon"));
        response.socialPhotos.add(new EventPhoto("http://www.gravatar.com/avatar/" + 38 + "?d=identicon"));

        bus.post(response);

    }
}
