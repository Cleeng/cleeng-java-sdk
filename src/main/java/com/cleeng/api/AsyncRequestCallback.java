package com.cleeng.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class AsyncRequestCallback<T> extends CompletableFuture<Response> {

    private Gson gson;

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

    private String _response;

    private Class<T> _responseClass;

    public T getResponse() {
        return gson.fromJson( this._response, this._responseClass );
    }

    @Override
    public boolean complete(final Response response) {
        final boolean out = super.complete(response);
        this._countdownLatch.countDown();
        System.out.println("Completed async request: " + response.getStatusCode() + " count: " + this._countdownLatch.getCount() + " response: " + this._responseClass.getCanonicalName());
        try {
            this._response = response.getResponseBody();
        } catch (Exception e) {

        }
        if (this.useNonBlockingMode == true) {
            if (this._countdownLatch.getCount() == 0) {
                try {
                    System.out.println("Closing connection...");
                    this._client.close();
                } catch (IOException e) {
                    System.out.println("Failed to close http connection...");
                }
            }
        }
        return out;
    }

    public boolean useNonBlockingMode = false;
}
