package com.cleeng.api.domain.async;

import org.jsonrpc.JSONRPCMessage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BatchRequest extends AsyncRequest {

    private List<JSONRPCMessage> requests;

    public BatchRequest() {
        super();
    }

    public BatchRequest(String endpoint) {
        super();
        this.endpoint = endpoint;
    }

    public void addRequest(JSONRPCMessage request) {
        if (this.requests == null) {
            this.requests = new ArrayList<JSONRPCMessage>();
        }
        this.requests.add(request);
        this.data = (Serializable) this.requests;
    }

    public int size() {
        return this.requests.size();
    }
}
