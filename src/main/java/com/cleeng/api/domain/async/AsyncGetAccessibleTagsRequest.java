package com.cleeng.api.domain.async;

import com.cleeng.api.AsyncRequestCallback;

public class AsyncGetAccessibleTagsRequest extends AsyncRequest {

    public String publisherToken;

    public String customerToken;

    public AsyncGetAccessibleTagsRequest(String publisherToken, String customerToken, AsyncRequestCallback callback) {
        super();

        this.callback = callback;
        this.publisherToken = publisherToken;
        this.customerToken = customerToken;
    }
}
