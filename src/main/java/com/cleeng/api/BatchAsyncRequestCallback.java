package com.cleeng.api;

import com.cleeng.api.domain.OfferRequest;
import com.cleeng.api.domain.OfferResult;
import com.cleeng.api.domain.async.BatchResponse;
import com.google.gson.internal.LinkedTreeMap;
import org.jsonrpc.JSONRPCMessage;
import org.jsonrpc.JSONRPCResponse;

import java.util.List;

public class BatchAsyncRequestCallback extends AsyncRequestCallback<BatchResponse> {

    private List<JSONRPCMessage> requests;

    public BatchAsyncRequestCallback(List<JSONRPCMessage> requests) {

        super(BatchResponse.class);

        this.requests = requests;
    }

    public BatchResponse getResponse() {
        BatchResponse batchResponse = this.gson.fromJson( this._response, this._responseClass );
        for (JSONRPCResponse response : batchResponse) {
            for (JSONRPCMessage request : this.requests) {
                if (request.id.equals(response.id)) {
                    //TODO: build Request/Result mapper
                    if (request instanceof OfferRequest) {
                        response.result = new OfferResult( (LinkedTreeMap<String, String>) response.result );
                    }
                }
            }
        }
        return batchResponse;
    }
}
