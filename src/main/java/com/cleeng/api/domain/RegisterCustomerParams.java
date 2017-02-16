package com.cleeng.api.domain;

import java.io.Serializable;

public class RegisterCustomerParams implements Serializable {

    public String publisherToken;

    public CustomerData customerData;

    public RegisterCustomerParams(String publisherToken, CustomerData customerData) {

        this.publisherToken = publisherToken;
        this.customerData = customerData;
    }
}
