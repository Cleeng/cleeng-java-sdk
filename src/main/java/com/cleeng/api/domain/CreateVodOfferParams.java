package com.cleeng.api.domain;

import java.io.Serializable;

public class CreateVodOfferParams implements Serializable {

    public String publisherToken;

    public VodOfferData offerData;

    public CreateVodOfferParams() {

    }

    public CreateVodOfferParams(String publisherToken, VodOfferData offerData) {
        this.publisherToken = publisherToken;
        this.offerData = offerData;
    }

    public static CreateVodOfferParams create(String publisherToken, VodOfferData offerData) {
        return new CreateVodOfferParams(publisherToken, offerData);
    }
}
