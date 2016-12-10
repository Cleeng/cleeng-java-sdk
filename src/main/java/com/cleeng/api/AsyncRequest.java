package com.cleeng.api;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

public class AsyncRequest {

    public String endpoint;

    public Serializable input;

    public Serializable data;

    public AsyncRequestCallback callback;

    public CountDownLatch latch;

    public AsyncRequest() {

    }

    public AsyncRequest(Serializable input, AsyncRequestCallback callback) {
        this.input = input;
        this.callback = callback;
    }
}
