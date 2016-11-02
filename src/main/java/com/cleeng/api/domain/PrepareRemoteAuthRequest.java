package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

/**
 * Created by Jesion on 2016-11-02.
 */
public class PrepareRemoteAuthRequest extends JSONRPCMessage {

    public String method;
    public PrepareRemoteAuthParams params;

    public PrepareRemoteAuthRequest() {

    }

    public PrepareRemoteAuthRequest(String method, PrepareRemoteAuthParams params) {
        this.method = method;
        this.params = params;
    }
}
