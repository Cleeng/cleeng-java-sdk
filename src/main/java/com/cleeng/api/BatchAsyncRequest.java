package com.cleeng.api;

import com.cleeng.api.domain.BatchResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsonrpc.JSONRPCMessage;
import org.jsonrpc.JSONRPCRequest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BatchAsyncRequest extends AsyncRequestCallback<BatchResponse> {

    private static final Logger logger = LogManager.getLogger(BatchAsyncRequest.class);

    private List<JSONRPCMessage> requests;

    private ResponseMapper mapper = new ResponseMapper();

    private int count = 0;

    public BatchAsyncRequest() {

        super(BatchResponse.class);

        this.requests = new ArrayList<JSONRPCMessage>();
    }

    public BatchAsyncRequest(List<JSONRPCMessage> requests) {

        super(BatchResponse.class);

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

    public BatchResponse getResponse() {
        final BatchResponse batchResponse = new BatchResponse();
        final JsonParser parser = new JsonParser();
        final JsonArray o = parser.parse(this._response).getAsJsonArray();
        for (int i = 0; i < o.size(); i++) {
            JsonElement element = o.get(i);
            for (int j = 0; j < this.requests.size(); j++) {
                JSONRPCRequest r = (JSONRPCRequest) this.requests.get(j);
                if (element.isJsonObject()) {
                    JsonObject res = element.getAsJsonObject();
                    if (res.get("id").getAsString().equals(r.id)) {
                        String responseTypeName = this.mapper.map(r.method);
                        if (responseTypeName != null) {
                            try {
                                logger.info("Processing " + responseTypeName);
                                Serializable payload = (Serializable) this.gson.fromJson(res, Class.forName(responseTypeName));
                                batchResponse.responses.add(payload);
                            } catch (ClassNotFoundException e) {
                                logger.error("Class not found " + e);
                            }
                        } else {
                            logger.warn("Mapper did not contain a response type for " + r.getClass().getTypeName());
                        }
                    }
                }
            }
        }
        return batchResponse;
    }
}
