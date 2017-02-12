package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

public class GetCustomerRequest extends JSONRPCMessage {

    public String method;
    public GetCustomerParams params;

    public GetCustomerRequest() {

    }

    public GetCustomerRequest(String method, GetCustomerParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }

}
