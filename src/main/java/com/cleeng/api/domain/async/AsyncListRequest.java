package com.cleeng.api.domain.async;

import com.cleeng.api.AsyncRequestCallback;

import java.io.Serializable;

public class AsyncListRequest extends AsyncRequest {

    public int offset;

    public int limit;

    public AsyncListRequest(Serializable input, AsyncRequestCallback callback, int offset, int limit) {
        super(input, callback);
        this.offset = offset;
        this.limit = limit;
    }
}
