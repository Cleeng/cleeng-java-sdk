package com.cleeng.api.domain;

import java.io.Serializable;

/**
 * Created by Jesion on 2016-10-29.
 */

public class OfferParams implements Serializable {

    public String publisherToken;
    public BaseOfferData offerData;

    public OfferParams(String publisherToken, BaseOfferData offerData) {

        this.publisherToken = publisherToken;
        this.offerData = offerData;
    }

    public static OfferParams create(String publisherToken, BaseOfferData offerData) {
        return new OfferParams(publisherToken, offerData);
    }
}
