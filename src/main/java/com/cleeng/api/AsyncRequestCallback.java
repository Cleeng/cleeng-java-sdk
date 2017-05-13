package com.cleeng.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class AsyncRequestCallback<T> extends CompletableFuture<Response> {

    private static final Logger logger = LogManager.getLogger(AsyncRequestCallback.class);

    protected Gson gson;

    public AsyncRequestCallback(Class<T> responseClass) {
        this.gson = new GsonBuilder().create();
        this._responseClass = responseClass;
    }

    private AsyncHttpClient _client;

    public void setClient(AsyncHttpClient client) {
        this._client = client;
    }

    private CountDownLatch _countdownLatch;

    public void setCountdownLatch(CountDownLatch latch) {
        this._countdownLatch = latch;
    }

    public CountDownLatch getCountdownLatch() {
        return this._countdownLatch;
    }

    protected String _response;

    protected Class<T> _responseClass;

    public T getResponse() {
        return gson.fromJson( this._response, this._responseClass );
    }

    @Override
    public boolean complete(final Response response) {
        final boolean out = super.complete(response);
        logger.info("Completed async request: " + response.getStatusCode() + " count: " + this._countdownLatch.getCount() + " response: " + this._responseClass.getCanonicalName());
        try {
            this._response = response.getResponseBody();
        } catch (Exception e) {

        }
        if (this.useNonBlockingMode == true) {
            if (this._countdownLatch.getCount() == 0) {
                try {
                    logger.info("Closing connection...");
                    this._client.close();
                } catch (IOException e) {
                    logger.error("Failed to close http connection...");
                }
            }
        }
        this._countdownLatch.countDown();
        return out;
    }

    @Override
    public boolean completeExceptionally(Throwable ex) {
        logger.error("Request completed with exception " + ex);
        return super.completeExceptionally(ex);
    }

    public boolean useNonBlockingMode = false;
}
