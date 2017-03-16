package com.cleeng.api.domain.async;

import com.cleeng.api.AsyncRequestCallback;

public class AsyncGetAccessStatusRequest extends AsyncRequest {

    public String offerId;

    public String customerToken;

    public String ipAddress;

    public AsyncGetAccessStatusRequest(String customerToken, String offerId, String ipAddress, AsyncRequestCallback callback) {
        super();

        this.callback = callback;
        this.offerId = offerId;
        this.customerToken = customerToken;
        this.ipAddress = ipAddress;
    }
}
