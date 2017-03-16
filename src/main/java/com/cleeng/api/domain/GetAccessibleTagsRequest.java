package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCRequest;

public class GetAccessibleTagsRequest extends JSONRPCRequest {

    public GetAccessibleTagsRequest(String method, GetAccessibleTagsParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
