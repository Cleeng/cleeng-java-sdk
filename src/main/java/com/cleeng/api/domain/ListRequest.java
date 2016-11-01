package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

/**
 * Created by Jesion on 2016-11-01.
 */
public class ListRequest extends JSONRPCMessage {

    public String method;
    public ListParams params;

    public ListRequest(String method, ListParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
