package com.cleeng.api;

import com.cleeng.api.domain.VodOfferData;

public class AsyncUpdateVodOfferRequest extends AsyncCreateVodOfferRequest {

    public String offerIdString;

    public AsyncUpdateVodOfferRequest(String publisherToken, VodOfferData offerData, AsyncRequestCallback callback, String offerId) {

        super(publisherToken, offerData, callback);

        this.offerIdString = offerId;
    }
}
