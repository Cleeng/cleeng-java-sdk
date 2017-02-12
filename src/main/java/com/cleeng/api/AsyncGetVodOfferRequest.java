package com.cleeng.api;

public class AsyncGetVodOfferRequest extends AsyncRequest {

    public String publisherToken;

    public String offerId;

    public AsyncGetVodOfferRequest(String publisherToken, String offerId, AsyncRequestCallback callback) {
        super();

        this.callback = callback;
        this.publisherToken = publisherToken;
        this.offerId = offerId;
    }
}
