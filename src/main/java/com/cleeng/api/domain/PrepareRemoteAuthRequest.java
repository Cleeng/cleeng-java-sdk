package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCRequest;

public class PrepareRemoteAuthRequest extends JSONRPCRequest {

    public PrepareRemoteAuthRequest(String method, PrepareRemoteAuthParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
