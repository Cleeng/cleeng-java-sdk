package com.cleeng.api.domain.async;

import com.cleeng.api.AsyncRequestCallback;

public class AsyncListCustomerSubscriptionsRequest extends AsyncRequest {

    public String publisherToken;

    public int offset;

    public int limit;

    public String customerEmail;

    public AsyncListCustomerSubscriptionsRequest(String publisherToken,
                                                 String customerEmail,
                                                 int offset,
                                                 int limit,
                                                 AsyncRequestCallback callback) {

        super();

        this.callback = callback;
        this.publisherToken = publisherToken;
        this.customerEmail = customerEmail;
        this.offset = offset;
        this.limit = limit;
    }
}