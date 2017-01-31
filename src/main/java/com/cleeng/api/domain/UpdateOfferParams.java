package com.cleeng.api.domain;

public class UpdateOfferParams extends OfferParams {

    public String offerId;

    public UpdateOfferParams(String publisherToken, BaseOfferDataRequest offerData, String offerId) {

        super(publisherToken, offerData);

        this.offerId = offerId;
    }
}
