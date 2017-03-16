package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCRequest;

public class RentalOfferRequest extends JSONRPCRequest {

    public RentalOfferRequest(String method, RentalOfferParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
