package com.cleeng.api.domain;

import java.io.Serializable;

/**
 * Created by Jesion on 2016-11-02.
 */
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
