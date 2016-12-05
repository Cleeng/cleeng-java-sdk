package com.cleeng.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.EntityUtils;

import java.util.concurrent.CountDownLatch;

public class AsyncRequestCallback<T> implements FutureCallback<HttpResponse> {

    private Gson gson;

    public AsyncRequestCallback(Class<T> responseClass) {
        this.gson = new GsonBuilder().create();
        this._responseClass = responseClass;
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
    }

    @Override
    public void failed(final Exception ex) {

    }

    @Override
    public void cancelled() {

    }
}
