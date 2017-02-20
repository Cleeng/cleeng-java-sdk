package com.cleeng.api.domain;

import java.io.Serializable;

public class UpdateOfferParams extends OfferParams {

    public String offerId;

    public UpdateOfferParams(String publisherToken, Serializable offerData, String offerId) {

        super(publisherToken, offerData);

        this.offerId = offerId;
    }
}
