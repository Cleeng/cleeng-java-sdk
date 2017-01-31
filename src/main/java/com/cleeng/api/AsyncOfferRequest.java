package com.cleeng.api;

import com.cleeng.api.domain.BaseOfferDataRequest;

public class AsyncOfferRequest extends AsyncRequest {

    public BaseOfferDataRequest offerData;

    public AsyncOfferRequest(BaseOfferDataRequest offerData, AsyncRequestCallback callback) {

        super();

        this.callback = callback;
         this.offerData = offerData;
    }
}
