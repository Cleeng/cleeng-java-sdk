package com.cleeng.api.domain;

import java.io.Serializable;

public class GetCustomerParams implements Serializable {

    public String customerToken;

    public GetCustomerParams() {

    }

    public GetCustomerParams(String customerToken) {
        this.customerToken = customerToken;
    }
}
