package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

/**
 * Created by Jesion on 2016-11-02.
 */
public class GetAccessStatusRequest extends JSONRPCMessage {

    public String method;
    public GetAccessStatusParams params;

    public GetAccessStatusRequest() {

    }

    public GetAccessStatusRequest(String method, GetAccessStatusParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
