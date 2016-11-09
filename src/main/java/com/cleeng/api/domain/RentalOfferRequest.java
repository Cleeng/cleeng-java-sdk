package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

public class RentalOfferRequest extends JSONRPCMessage {

    public String method;
    public RentalOfferParams params;

    public RentalOfferRequest(String method, RentalOfferParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
