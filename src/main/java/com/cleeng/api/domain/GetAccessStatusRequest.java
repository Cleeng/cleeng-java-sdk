package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCRequest;

public class GetAccessStatusRequest extends JSONRPCRequest {

    public GetAccessStatusRequest() {

    }

    public GetAccessStatusRequest(String method, GetAccessStatusParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
