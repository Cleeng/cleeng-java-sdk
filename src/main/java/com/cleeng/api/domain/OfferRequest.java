package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

public class OfferRequest extends JSONRPCMessage {

    public String method;
    public OfferParams params;

    public OfferRequest(String method, OfferParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
