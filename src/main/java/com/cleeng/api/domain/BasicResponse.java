package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

public class BasicResponse extends JSONRPCMessage {

    public Object result;

    public BasicResponse() {

    }

    public BasicResponse(Object result) {

        this.result = result;
    }
}
