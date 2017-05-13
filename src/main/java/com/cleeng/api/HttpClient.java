package com.cleeng.api;

import com.cleeng.api.domain.BatchRequest;
import com.cleeng.api.domain.async.AsyncRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nurkiewicz.asyncretry.AsyncRetryExecutor;
import com.nurkiewicz.asyncretry.RetryExecutor;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.asynchttpclient.*;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.List;
import java.util.concurrent.*;

@SuppressWarnings("unchecked")
public class HttpClient {

    private static final Logger logger = LogManager.getLogger(HttpClient.class);

    public Config config;

    public synchronized String invokeBatch(BatchRequest request, String platformUrl) throws IOException {
        return this.invoke(platformUrl, request.getRequests());
    }

    public synchronized String invoke(String endpoint, Object request) throws IOException {
        final StandardHttpRequestRetryHandler retryHandler =
                new StandardHttpRequestRetryHandler(this.config.retryCount, true)
                {
                    @Override
                    public boolean retryRequest(
                            final IOException exception,
                            final int executionCount,
                            final HttpContext context)
                    {
                        if (executionCount < this.getRetryCount()) {
                            return true;
                        }
                        return false;
                    }
                };
        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setRetryHandler(retryHandler)
                .build()) {
            HttpPost post = new HttpPost(endpoint);
            post.setHeader("Content-Type", "application/json");
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(request);
            post.setEntity(new StringEntity(json, "UTF-8"));
            RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(this.config.socketTimeout)
                .setConnectTimeout(this.config.connectTimeout)
                .build();
            post.setConfig(requestConfig);
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(HttpResponse httpResponse) throws IOException {
                    StatusLine statusLine = httpResponse.getStatusLine();
                    HttpEntity entity = httpResponse.getEntity();
                    if (statusLine.getStatusCode() >= 300) {
                        logger.error(" Server returned response code: " + statusLine.getStatusCode() + " reason: " + statusLine.getReasonPhrase());
                        throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
                    }
                    if (entity == null) {
                        throw new ClientProtocolException("Response contains no content");
                    }
                    return EntityUtils.toString(entity);
                }
            };
            try {
                return httpClient.execute(post, responseHandler);
            } catch (InterruptedIOException exception) {
                return null;
            }
        }
    }

    public synchronized CompletableFuture<Response> invokeAsync(AsyncRequest request,
                                                                CountDownLatch latch,
                                                                AsyncHttpClient httpClient) throws IOException, InterruptedException {
        request.latch = latch;
        request.callback.useNonBlockingMode = this.config.useNonBlockingMode;
        request.callback.setCountdownLatch(latch);
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(request.data);
        final BoundRequestBuilder builder = httpClient.preparePost(request.endpoint);
        builder.addHeader("Content-Type", "application/json");
        builder.setBody(json);
        request.callback.setClient(httpClient);
        builder.execute(
            new AsyncCompletionHandler<Void>() {

                @Override
                public Void onCompleted(Response response) throws Exception {
                    request.callback.complete(response);
                    return null;
                }

                @Override
                public void onThrowable(Throwable t) {
                    request.callback.completeExceptionally(t);
                }
            }
        );
        request.callback.join();
        return request.callback;
    }

    public synchronized void invokeAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
        final DefaultAsyncHttpClientConfig.Builder builder = new DefaultAsyncHttpClientConfig.Builder();
        builder.setRequestTimeout(this.config.requestTimeout);
        builder.setConnectTimeout(this.config.connectTimeout);
        final AsyncHttpClient httpClient = new DefaultAsyncHttpClient(builder.build());
        final CountDownLatch latch = new CountDownLatch(requests.size());
        final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        final RetryExecutor executor = new AsyncRetryExecutor(scheduler)
                .retryOn(Exception.class)
                .withMaxRetries(this.config.retryCount);
        try {
            for (AsyncRequest request : requests) {
                executor.getWithRetry(() -> this.invokeAsync(request, latch, httpClient));
            }
            if (this.config.useNonBlockingMode == false) {
                latch.await();
            }
        } finally {
            if (this.config.useNonBlockingMode == false) {
                httpClient.close();
            }
        }
    }

    public synchronized  void invokeBatchAsync(BatchAsyncRequest callback, String platformUrl) throws IOException, InterruptedException {
        final DefaultAsyncHttpClientConfig.Builder builder = new DefaultAsyncHttpClientConfig.Builder();
        builder.setRequestTimeout(this.config.requestTimeout);
        builder.setConnectTimeout(this.config.connectTimeout);
        final AsyncHttpClient httpClient = new DefaultAsyncHttpClient(builder.build());
        final CountDownLatch latch = new CountDownLatch(1);
        final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        final RetryExecutor executor = new AsyncRetryExecutor(scheduler)
                .retryOn(Exception.class)
                .withMaxRetries(this.config.retryCount);

        try {
            executor.getWithRetry(() -> this.invokeAsync(callback, latch, httpClient, platformUrl));
            if (this.config.useNonBlockingMode == false) {
                latch.await();
            }
        } finally {
            if (this.config.useNonBlockingMode == false) {
                httpClient.close();
            }
        }
    }

    public synchronized CompletableFuture<Response> invokeAsync(BatchAsyncRequest request,
                                                                CountDownLatch latch,
                                                                AsyncHttpClient httpClient,
                                                                String platformUrl) throws IOException, InterruptedException {
        request.setCountdownLatch(latch);
        request.useNonBlockingMode = this.config.useNonBlockingMode;
        request.setCountdownLatch(latch);
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(request.getRequests());
        final BoundRequestBuilder builder = httpClient.preparePost(platformUrl);
        builder.addHeader("Content-Type", "application/json");
        builder.setBody(json);
        request.setClient(httpClient);
        builder.execute(
                new AsyncCompletionHandler<Void>() {

                    @Override
                    public Void onCompleted(Response response) throws Exception {
                        request.complete(response);
                        return null;
                    }

                    @Override
                    public void onThrowable(Throwable t) {
                        request.completeExceptionally(t);
                    }
                }
        );
        request.join();
        return request;
    }
}
