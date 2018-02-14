package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCRequest;

public class UpdateCustomerSubscriptionRequest extends JSONRPCRequest {

    public UpdateCustomerSubscriptionRequest(String method, UpdateCustomerSubscriptionParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
