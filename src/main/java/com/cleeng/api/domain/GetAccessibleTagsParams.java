package com.cleeng.api.domain;

import java.io.Serializable;

public class GetAccessibleTagsParams implements Serializable {

    public String publisherToken;
    public String customerToken;

    public GetAccessibleTagsParams() {

    }

    public GetAccessibleTagsParams(String publisherToken, String customerToken) {
        this.publisherToken = publisherToken;
        this.customerToken = customerToken;
    }
}
