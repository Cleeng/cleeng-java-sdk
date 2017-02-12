package com.cleeng.api;

import java.io.Serializable;

public class AsyncOfferRequest extends AsyncRequest {

    public Serializable offerData;

    public AsyncOfferRequest(Serializable offerData, AsyncRequestCallback callback) {

        super();

        this.callback = callback;
        this.offerData = offerData;
    }
}
