package com.cleeng.api.domain;

import java.io.Serializable;

public class GenerateCheckoutUrlParams implements Serializable {

    public String publisherToken;

    public String customerEmail;

    public FlowDescription flowDescription;

    public GenerateCheckoutUrlParams(String publisherToken, String customerEmail, FlowDescription flowDescription) {

        this.publisherToken = publisherToken;
        this.customerEmail = customerEmail;
        this.flowDescription = flowDescription;
    }
}
