package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

public class GenerateCustomerTokenRequest extends JSONRPCMessage {

    public String method;
    public GenerateCustomerTokenParams params;

    public GenerateCustomerTokenRequest() {

    }

    public GenerateCustomerTokenRequest(String method, GenerateCustomerTokenParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
