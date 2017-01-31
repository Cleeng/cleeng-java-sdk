package com.cleeng.api.domain;

import java.io.Serializable;

public class OfferParams implements Serializable {

    public String publisherToken;
    public Serializable offerData;

    public OfferParams(String publisherToken, Serializable offerData) {

        this.publisherToken = publisherToken;
        this.offerData = offerData;
    }

    public static OfferParams create(String publisherToken, Serializable offerData) {
        return new OfferParams(publisherToken, offerData);
    }
}
