package com.cleeng.api;

public class AsyncTokenRequest extends AsyncRequest {

    public String input;

    public AsyncTokenRequest(AsyncRequestCallback callback, String input) {
        super();

        this.callback = callback;
        this.input = input;
    }
}
