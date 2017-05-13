package com.cleeng.api.examples;

import com.cleeng.api.domain.async.AsyncRequest;
import com.cleeng.api.AsyncRequestCallback;
import com.cleeng.api.Cleeng;
import com.cleeng.api.CleengFactory;
import com.cleeng.api.domain.OfferResponse;
import com.cleeng.api.domain.SubscriptionOfferData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CleengJavaAPIExampleAsync {

    private static final Logger logger = LogManager.getLogger(CleengJavaAPIExampleAsync.class);

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

        final AsyncRequestCallback<OfferResponse> callback = new AsyncRequestCallback<OfferResponse>(OfferResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(offerData, callback));

        api.createSubscriptionOfferAsync(requests);

        Thread.sleep(2000);

        logger.info("Done. Created offer id: " + callback.getResponse().result.id);

        System.exit(0);
    }
}