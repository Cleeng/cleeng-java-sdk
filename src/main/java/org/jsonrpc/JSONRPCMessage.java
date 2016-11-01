package org.jsonrpc;

import java.io.Serializable;


/**
 * Created by Jesion on 2016-10-29.
 */
public class JSONRPCMessage implements Serializable {

    public String jsonrpc;
    public String id;
    public Error error;

    public JSONRPCMessage() {

    }

    public JSONRPCMessage(String id, String jsonrpc, Error error) {
        this.id = id;
        this.jsonrpc = jsonrpc;
        this.error = error;
    }

    public JSONRPCMessage(String id, String jsonrpc) {
        this(id, jsonrpc, null);
    }
}
