package com.cleeng.api.examples;

import com.cleeng.api.Cleeng;
import com.cleeng.api.CleengFactory;
import com.cleeng.api.domain.*;

import java.util.Arrays;

public class CleengJavaAPIBatchExample {

    public static void main(String args[]) throws Exception {

        String publisherToken = "IEiuf3fJzAorVvxgBYiHiHXGk8oFPckTMSOn8hS1--lOti30";
        Cleeng api = CleengFactory.createSandboxApi(publisherToken);

        SubscriptionOfferData offerData = new SubscriptionOfferData(12.34,
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

        OfferRequest createOffer = new OfferRequest("createSubscriptionOffer", OfferParams.create(publisherToken, offerData));
        ListRequest listOffers = new ListRequest("listSubscriptionOffers", ListParams.create(publisherToken, new Criteria(true), 0, 10));

        BatchRequest batch = new BatchRequest();
        batch.addRequest(createOffer);
        batch.addRequest(listOffers);

        BatchResponse response = api.invokeBatch(batch);

        System.out.println("Done. Number of responses available: " + response.responses.size());
    }
}
