package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCRequest;

public class GetCustomerRequest extends JSONRPCRequest {

    public GetCustomerRequest(String method, GetCustomerParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
