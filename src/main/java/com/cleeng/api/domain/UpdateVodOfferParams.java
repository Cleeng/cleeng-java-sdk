package com.cleeng.api.domain;

public class UpdateVodOfferParams extends CreateVodOfferParams {

    public String offerIdString;

    public UpdateVodOfferParams(String publisherToken, VodOfferData offerData, String offerId) {
        this.publisherToken = publisherToken;
        this.offerData = offerData;
        this.offerIdString = offerId;
    }

    public static UpdateVodOfferParams create(String publisherToken, VodOfferData offerData, String offerId) {
        return new UpdateVodOfferParams(publisherToken, offerData, offerId);
    }
}
