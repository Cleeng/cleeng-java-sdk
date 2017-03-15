package com.cleeng.api;

import com.cleeng.api.domain.OfferRequest;
import com.cleeng.api.domain.OfferResponse;
import com.cleeng.api.domain.async.BatchResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jsonrpc.JSONRPCMessage;

import java.util.List;

public class BatchAsyncRequestCallback extends AsyncRequestCallback<BatchResponse> {

    private List<JSONRPCMessage> requests;

    public BatchAsyncRequestCallback(List<JSONRPCMessage> requests) {

        super(BatchResponse.class);

        this.requests = requests;
    }

    public BatchResponse getResponse() {
        final BatchResponse batchResponse = new BatchResponse();
        final JsonParser parser = new JsonParser();
        final JsonArray o = parser.parse(this._response).getAsJsonArray();
        for (int i = 0; i < o.size(); i++) {
            JsonElement element = o.get(i);
            for (int j = 0; j < this.requests.size(); j++) {
                JSONRPCMessage r = this.requests.get(j);
                if (element.isJsonObject()) {
                    JsonObject res = element.getAsJsonObject();
                    if (res.get("id").getAsString().equals(r.id)) {
                        //TODO: Mapper will handle OfferRequest/OfferResponse mapping
                        if (r instanceof OfferRequest) {
                            OfferResponse resPayload = this.gson.fromJson(res, OfferResponse.class);
                            batchResponse.responses.add(resPayload);
                        }
                    }
                }
            }
        }
        return batchResponse;
    }
}
