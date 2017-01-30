package com.cleeng.api;

import com.cleeng.api.domain.VodOfferData;

public class AsyncCreateVodOfferRequest extends AsyncRequest {

    public String publisherToken;

    public VodOfferData offerData;

    public AsyncCreateVodOfferRequest(String publisherToken, VodOfferData offerData, AsyncRequestCallback callback) {
        super();

        this.callback = callback;
        this.publisherToken = publisherToken;
        this.offerData = offerData;
    }
}
