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
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class HttpClient {
    public synchronized String invoke( String endpoint, Serializable request ) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(endpoint);
            post.setHeader("Content-Type", "application/json");
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson( request );
            post.setEntity( new StringEntity( json, "UTF-8" ));
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                    StatusLine statusLine = httpResponse.getStatusLine();
                    HttpEntity entity = httpResponse.getEntity();
                    if (statusLine.getStatusCode() >= 300) {
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

    public void invokeAsync( List<AsyncRequest> requests ) throws IOException, InterruptedException {
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(3000)
                .setConnectTimeout(3000).build();
        CloseableHttpAsyncClient httpClient = HttpAsyncClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();
        try {
            httpClient.start();
            final CountDownLatch latch = new CountDownLatch(requests.size());
            for (final AsyncRequest request : requests) {
                request.latch = latch;
                request.callback.setCountdownLatch(latch);
                HttpPost post = new HttpPost( request.endpoint );
                post.setHeader("Content-Type", "application/json");
                Gson gson = new GsonBuilder().create();
                String json = gson.toJson( request.data );
                post.setEntity( new StringEntity( json, "UTF-8" ));
                httpClient.execute( post, request.callback );
            }
            latch.await();
        } finally {
            httpClient.close();
        }
    }
}
