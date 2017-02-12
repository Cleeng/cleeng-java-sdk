package com.cleeng.api;

import com.cleeng.api.domain.FlowDescription;

public class AsyncGenerateCheckoutUrlRequest extends AsyncRequest {

    public String publisherToken;

    public String customerEmail;

    public FlowDescription flowDescription;

    public AsyncGenerateCheckoutUrlRequest(String publisherToken,
                                           String customerEmail,
                                           FlowDescription flowDescription,
                                           AsyncRequestCallback callback) {
        super();

        this.callback = callback;
        this.publisherToken = publisherToken;
        this.customerEmail = customerEmail;
        this.flowDescription = flowDescription;
    }
}
