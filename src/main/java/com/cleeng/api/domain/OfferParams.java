package com.cleeng.api.domain;

import java.io.Serializable;

/**
 * Created by Jesion on 2016-10-29.
 */

public class OfferParams implements Serializable {

    public String publisherToken;
    public OfferData offerData;

    public OfferParams(String publisherToken, OfferData offerData) {

        this.publisherToken = publisherToken;
        this.offerData = offerData;
    }

    public static OfferParams create(String publisherToken, OfferData offerData) {
        return new OfferParams(publisherToken, offerData);
    }
}
