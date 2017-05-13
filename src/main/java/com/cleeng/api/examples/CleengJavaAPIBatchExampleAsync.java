package com.cleeng.api.examples;

import com.cleeng.api.BatchAsyncRequest;
import com.cleeng.api.Cleeng;
import com.cleeng.api.CleengFactory;
import com.cleeng.api.domain.*;
import com.cleeng.api.domain.BatchResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class CleengJavaAPIBatchExampleAsync {

    private static final Logger logger = LogManager.getLogger(CleengJavaAPIBatchExampleAsync.class);

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

        BatchAsyncRequest batch = new BatchAsyncRequest();
        batch.addRequest(createOffer);
        batch.addRequest(listOffers);

        api.invokeBatchAsync(batch);

        TimeUnit.SECONDS.sleep(4);

        final BatchResponse response = batch.getResponse();

        logger.info("Done. Number of responses available: " + response.responses.size());

        System.exit(0);
    }
}
