package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

/**
 * Created by Jesion on 2016-11-02.
 */
public class GenerateCustomerTokenRequest extends JSONRPCMessage {

    public String method;
    public GenerateCustomerTokenParams params;

    public GenerateCustomerTokenRequest() {

    }

    public GenerateCustomerTokenRequest(String method, GenerateCustomerTokenParams params) {
        this.method = method;
        this.params = params;
    }
}
