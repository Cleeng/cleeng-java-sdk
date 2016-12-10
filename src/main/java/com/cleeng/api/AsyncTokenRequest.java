package com.cleeng.api;

public class AsyncTokenRequest extends AsyncRequest {

    public String customerEmail;

    public AsyncTokenRequest(AsyncRequestCallback callback, String customerEmail) {
        super();

        this.callback = callback;
        this.customerEmail = customerEmail;
    }
}
