package com.cleeng.api;

import java.io.Serializable;

public class AsyncUpdateOfferRequest extends AsyncOfferRequest {

    public String offerId;

    public AsyncUpdateOfferRequest(Serializable offerData, AsyncRequestCallback callback, String offerId) {

        super(offerData, callback);

        this.offerId = offerId;
    }
}
