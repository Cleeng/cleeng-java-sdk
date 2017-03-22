package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCRequest;

public class ListRequest extends JSONRPCRequest {

    public ListRequest(String method, ListParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
