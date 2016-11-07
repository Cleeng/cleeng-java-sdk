package com.cleeng.api.domain;

import java.io.Serializable;

/**
 * Created by Jesion on 2016-10-29.
 */

public class OfferParams implements Serializable {

    public String publisherToken;
    public BaseOfferDataRequest offerData;

    public OfferParams(String publisherToken, BaseOfferDataRequest offerData) {

        this.publisherToken = publisherToken;
        this.offerData = offerData;
    }

    public static OfferParams create(String publisherToken, BaseOfferDataRequest offerData) {
        return new OfferParams(publisherToken, offerData);
    }
}
