package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

public class CreateVodOfferRequest extends JSONRPCMessage {

    public String method;

    public CreateVodOfferParams params;

    public CreateVodOfferRequest() {

    }

    public CreateVodOfferRequest(String method, CreateVodOfferParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
