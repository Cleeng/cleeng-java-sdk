package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCRequest;

public class VodOfferRequest extends JSONRPCRequest {

    public VodOfferRequest(String method, CreateVodOfferParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
