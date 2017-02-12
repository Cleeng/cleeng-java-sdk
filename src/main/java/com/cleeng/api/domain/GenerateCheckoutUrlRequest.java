package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

public class GenerateCheckoutUrlRequest extends JSONRPCMessage {

    public String method;
    public GenerateCheckoutUrlParams params;

    public GenerateCheckoutUrlRequest() {

    }

    public GenerateCheckoutUrlRequest(String method, GenerateCheckoutUrlParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
