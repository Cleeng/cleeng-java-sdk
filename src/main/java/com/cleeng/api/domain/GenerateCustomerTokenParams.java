package com.cleeng.api.domain;

import java.io.Serializable;

public class GenerateCustomerTokenParams implements Serializable {

    public String publisherToken;

    public String customerEmail;

    public GenerateCustomerTokenParams() {

    }

    public GenerateCustomerTokenParams(String publisherToken, String customerEmail) {
        this.publisherToken = publisherToken;
        this.customerEmail = customerEmail;
    }

    public static GenerateCustomerTokenParams create(String publisherToken, String customerEmail) {
        return new GenerateCustomerTokenParams(publisherToken, customerEmail);
    }
}
