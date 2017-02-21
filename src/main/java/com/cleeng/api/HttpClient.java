package com.cleeng.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class HttpClient {

    public Config config;

    public synchronized String invoke(String endpoint, Serializable request) throws IOException {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setRetryHandler(new DefaultHttpRequestRetryHandler(this.config.retryCount, false))
                .build()) {
            HttpPost post = new HttpPost(endpoint);
            post.setHeader("Content-Type", "application/json");
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(request);
            post.setEntity(new StringEntity(json, "UTF-8"));
            RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(this.config.socketTimeout)
                .setConnectTimeout(this.config.connectionTimeout)
                .build();
            post.setConfig(requestConfig);
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                    StatusLine statusLine = httpResponse.getStatusLine();
                    HttpEntity entity = httpResponse.getEntity();
                    if (statusLine.getStatusCode() >= 300) {
                        System.out.println(" Server returned response code: " + statusLine.getStatusCode() + " reason: " + statusLine.getReasonPhrase());
                        throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
                    }
                    if (entity == null) {
                        throw new ClientProtocolException("Response contains no content");
                    }
                    return EntityUtils.toString(entity);
                }
            };
            return httpClient.execute(post, responseHandler);
        }
    }

    @SuppressWarnings("unchecked")
    public synchronized void invokeAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(this.config.socketTimeout)
                .setConnectTimeout(this.config.connectionTimeout).build();
        CloseableHttpAsyncClient httpClient = HttpAsyncClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .build();
        try {
            httpClient.start();
            final CountDownLatch latch = new CountDownLatch(requests.size());
            for (int i = 0; i < requests.size(); i++) {
                AsyncRequest request = requests.get(i);
                request.latch = latch;
                request.callback.useNonBlockingMode = this.config.useNonBlockingMode;
                request.callback.setCountdownLatch(latch);
                HttpPost post = new HttpPost(request.endpoint);
                post.setHeader("Content-Type", "application/json");
                Gson gson = new GsonBuilder().create();
                String json = gson.toJson(request.data);
                post.setEntity(new StringEntity(json, "UTF-8"));
                request.callback.setClient(httpClient);
                httpClient.execute(post, request.callback);
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
}
