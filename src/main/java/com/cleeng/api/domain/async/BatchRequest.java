package com.cleeng.api.domain.async;

import org.jsonrpc.JSONRPCMessage;

import java.util.ArrayList;
import java.util.List;

public class BatchRequest {

    public List<JSONRPCMessage> requests;

    public BatchRequest() {

    }

    public BatchRequest(List<JSONRPCMessage> requests) {
        this.requests = requests;
    }

    public void addRequest(JSONRPCMessage request) {
        if (this.requests == null) {
            this.requests = new ArrayList<JSONRPCMessage>();
        }
        this.requests.add(request);
    }
}
