package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCRequest;

public class ListCustomerSubscriptionsRequest extends JSONRPCRequest {

    public ListCustomerSubscriptionsRequest(String method, ListCustomerSubscriptionsParams params) {

        super("1", "2.0");

        this.method = method;
        this.params = params;
    }
}
