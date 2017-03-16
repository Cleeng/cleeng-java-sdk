package com.cleeng.api;

import java.util.HashMap;
import java.util.Map;

public class ResponseMapper {

    private Map<String, String> map;

    public ResponseMapper() {

        this.map = new HashMap<String, String>();
        this.build();
    }

    public String map(String methodName) {
        return this.map.get(methodName);
    }

    private void build() {
        this.map.put("createSubscriptionOffer", "com.cleeng.api.domain.OfferResponse");
        this.map.put("listSubscriptionOffers", "com.cleeng.api.domain.ListSubscriptionOffersResponse");
    }
}
