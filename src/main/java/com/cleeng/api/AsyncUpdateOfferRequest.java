package com.cleeng.api;

import com.cleeng.api.domain.BaseOfferDataRequest;

public class AsyncUpdateOfferRequest extends AsyncOfferRequest {

    public String offerId;

    public AsyncUpdateOfferRequest(BaseOfferDataRequest offerData, AsyncRequestCallback callback, String offerId) {

        super(offerData, callback);

        this.offerId = offerId;
    }
}
