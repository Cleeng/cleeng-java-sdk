package com.cleeng.api.domain.async;

import com.cleeng.api.AsyncRequestCallback;

public class AsyncGenerateCustomerTokenFromPasswordRequest extends AsyncRequest {

    public String publisherToken;

    public String password;

    public String customerEmail;

    public AsyncGenerateCustomerTokenFromPasswordRequest(String publisherToken, String password, String customerEmail, AsyncRequestCallback callback) {
        super();

        this.callback = callback;
        this.publisherToken = publisherToken;
        this.password = password;
        this.customerEmail = customerEmail;
    }
}
