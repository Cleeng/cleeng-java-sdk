package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

/**
 * Created by Jesion on 2016-11-02.
 */
public class GetAccessibleTagsRequest extends JSONRPCMessage {

    public String method;
    public GetAccessibleTagsParams params;

    public GetAccessibleTagsRequest() {

    }

    public GetAccessibleTagsRequest(String method, GetAccessibleTagsParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
