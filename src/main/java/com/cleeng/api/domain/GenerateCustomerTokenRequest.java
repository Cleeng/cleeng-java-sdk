package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

import java.io.Serializable;

public class GenerateCustomerTokenRequest extends JSONRPCMessage {

    public String method;
    public Serializable params;

    public GenerateCustomerTokenRequest() {

    }

    public GenerateCustomerTokenRequest(String method, Serializable params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
