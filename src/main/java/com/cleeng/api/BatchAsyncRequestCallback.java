package com.cleeng.api;

import com.cleeng.api.domain.async.BatchResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jsonrpc.JSONRPCMessage;

import java.io.Serializable;
import java.util.List;

public class BatchAsyncRequestCallback extends AsyncRequestCallback<BatchResponse> {

    private List<JSONRPCMessage> requests;

    private ResponseMapper mapper = new ResponseMapper();

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
                        String responseTypeName = this.mapper.map(r.getClass().getName());
                        try {
                            Serializable payload = (Serializable) this.gson.fromJson(res, Class.forName(responseTypeName));
                            batchResponse.responses.add(payload);
                        } catch (ClassNotFoundException e) {
                            System.out.println("Class not found: " + e);
                        }
                    }
                }
            }
        }
        return batchResponse;
    }
}
