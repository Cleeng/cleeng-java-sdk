package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCRequest;

public class GetVodOfferRequest extends JSONRPCRequest {

    public GetVodOfferRequest(String method, GetVodOfferParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
