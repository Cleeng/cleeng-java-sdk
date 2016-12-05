package com.cleeng.api;

import org.apache.http.HttpResponse;
import org.apache.http.concurrent.FutureCallback;
import java.util.concurrent.CountDownLatch;

public class AsyncRequestCallback implements FutureCallback<HttpResponse> {

    public AsyncRequestCallback() {

    }

    private CountDownLatch _countdownLatch;

    public void setCountdownLatch(CountDownLatch latch) {
        this._countdownLatch = latch;
    }

    @Override
    public void completed(final HttpResponse response) {
        this._countdownLatch.countDown();
        System.out.println("Completed async request: " + response.getStatusLine() + " count: " + this._countdownLatch.getCount());
    }

    @Override
    public void failed(final Exception ex) {

    }

    @Override
    public void cancelled() {

    }
}
