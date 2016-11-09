package com.cleeng.api.domain;

import java.io.Serializable;

public class RentalOfferParams implements Serializable {

    public String publisherToken;
    public RentalOfferData offerData;

    public RentalOfferParams(String publisherToken, RentalOfferData offerData) {
        this.publisherToken = publisherToken;
        this.offerData = offerData;
    }

    public static RentalOfferParams create(String publisherToken, RentalOfferData offerData) {
        return new RentalOfferParams( publisherToken, offerData );
    }
}
