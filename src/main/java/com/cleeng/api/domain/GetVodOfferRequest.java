package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

public class GetVodOfferRequest extends JSONRPCMessage {

    public String method;
    public GetVodOfferParams params;

    public GetVodOfferRequest() {

    }

    public GetVodOfferRequest(String method, GetVodOfferParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
