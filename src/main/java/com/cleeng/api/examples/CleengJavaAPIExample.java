package com.cleeng.api.examples;

import java.lang.System;
import java.util.Arrays;

import com.cleeng.api.*;
import com.cleeng.api.domain.OfferResponse;
import com.cleeng.api.domain.SubscriptionOfferData;

class CleengJavaAPIExample {

    public static void main(String args[]) throws Exception {

        String publisherToken = "IEiuf3fJzAorVvxgBYiHiHXGk8oFPckTMSOn8hS1--lOti30";
        Cleeng api = CleengFactory.createSandboxApi(publisherToken);

        final SubscriptionOfferData offerData = new SubscriptionOfferData(12.34,
                "week",
                "title",
                "http://www.someurl.com",
                "description",
                null,
                0,
                9,
                Arrays.asList("Sport"),
                true,
                "whitelist",
                Arrays.asList("PL", "DE")
        );
        final OfferResponse response = api.createSubscriptionOffer(offerData);

        System.out.println("Done. Created offer id: " + response.result.id);
    }
}