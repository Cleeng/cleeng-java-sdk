package com.cleeng.api.domain;

import java.io.Serializable;

public class ListCustomerSubscriptionsParams implements Serializable {

    public String publisherToken;
    public String customerEmail;
    public Integer offset;
    public Integer limit;

    public ListCustomerSubscriptionsParams(String publisherToken,
                                           String customerEmail,
                                           int offset,
                                           int limit) {
        this.publisherToken = publisherToken;
        this.customerEmail = customerEmail;
        this.offset = offset;
        this.limit = limit;
    }

    public ListCustomerSubscriptionsParams(String customerEmail,
                                           int offset,
                                           int limit) {
        this.customerEmail = customerEmail;
        this.offset = offset;
        this.limit = limit;
    }
}
