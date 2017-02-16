package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

public class VodOfferRequest extends JSONRPCMessage {

    public String method;

    public CreateVodOfferParams params;

    public VodOfferRequest() {

    }

    public VodOfferRequest(String method, CreateVodOfferParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
