package com.cleeng.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class AsyncRequestCallback<T> implements FutureCallback<HttpResponse> {

    private Gson gson;

    public AsyncRequestCallback(Class<T> responseClass) {
        this.gson = new GsonBuilder().create();
        this._responseClass = responseClass;
    }

    private CloseableHttpAsyncClient _client;

    public void setClient(CloseableHttpAsyncClient client) {
        this._client = client;
    }

    private CountDownLatch _countdownLatch;

    public void setCountdownLatch(CountDownLatch latch) {
        this._countdownLatch = latch;
    }

    private String _response;

    private Class<T> _responseClass;

    public T getResponse() {
        return gson.fromJson( this._response, this._responseClass );
    }

    @Override
    public void completed(final HttpResponse response) {
        this._countdownLatch.countDown();
        System.out.println("Completed async request: " + response.getStatusLine() + " count: " + this._countdownLatch.getCount() + " response: " + this._responseClass.getCanonicalName());
        final HttpEntity entity = response.getEntity();
        try {
            this._response = EntityUtils.toString(entity);
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
    }

    @Override
    public void failed(final Exception ex) {

    }

    @Override
    public void cancelled() {

    }

    private int _index;

    public void setIndex(int i) {
        this._index = i;
    }

    public int getIndex() {
        return this._index;
    }

    private int _batchSize;

    public void setBatchSize(int batchSize) {
        this._batchSize = batchSize;
    }

    public int getBatchSize() {
        return this._batchSize;
    }

    public boolean useNonBlockingMode = false;
}
