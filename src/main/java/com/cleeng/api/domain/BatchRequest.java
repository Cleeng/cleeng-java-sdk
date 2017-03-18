package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;
import org.jsonrpc.JSONRPCRequest;

import java.util.ArrayList;
import java.util.List;

public class BatchRequest {

    private List<JSONRPCMessage> requests;

    private int count = 0;

    public BatchRequest() {
        this.requests = new ArrayList<JSONRPCMessage>();
    }

    public BatchRequest(List<JSONRPCMessage> requests) {
        this.requests = requests;
    }

    public void addRequest(JSONRPCRequest request) {
        request.id = Integer.toString(this.count);
        this.requests.add(request);
        this.count++;
    }

    public List<JSONRPCMessage> getRequests() {
        return this.requests;
    }
}
