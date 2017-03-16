package com.cleeng.api;

import java.util.HashMap;
import java.util.Map;

public class ResponseMapper {

    private Map<String, String> map;

    public ResponseMapper() {

        this.map = new HashMap<String, String>();
        this.build();
    }

    public String map(String request) {
        return this.map.get(request);
    }

    private void build() {
        this.map.put("com.cleeng.api.domain.OfferRequest", "com.cleeng.api.domain.OfferResponse");
    }
}
