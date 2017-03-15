package com.cleeng.api.domain.async;

import com.cleeng.api.AsyncRequestCallback;

public class AsyncTokenRequest extends AsyncRequest {

    public String input;

    public AsyncTokenRequest(AsyncRequestCallback callback, String input) {
        super();

        this.callback = callback;
        this.input = input;
    }
}
