package com.cleeng.api;

import com.cleeng.api.domain.async.BatchResponse;

public class BatchAsyncRequestCallback extends AsyncRequestCallback<BatchResponse> {

    public BatchAsyncRequestCallback() {

        super(BatchResponse.class);
    }
}
