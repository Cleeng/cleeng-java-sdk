package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCRequest;

public class OfferRequest extends JSONRPCRequest {

    public OfferRequest(String method, OfferParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
