package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCRequest;

public class GenerateCheckoutUrlRequest extends JSONRPCRequest {

    public GenerateCheckoutUrlRequest(String method, GenerateCheckoutUrlParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
