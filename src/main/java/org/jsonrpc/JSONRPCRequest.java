package org.jsonrpc;

import java.io.Serializable;

public class JSONRPCRequest extends JSONRPCMessage {

    public String method;
    public Serializable params;

    public JSONRPCRequest() {

    }

    public JSONRPCRequest(String method, Serializable params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }
}
