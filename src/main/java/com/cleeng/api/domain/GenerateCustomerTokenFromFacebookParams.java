package com.cleeng.api.domain;

import java.io.Serializable;

public class GenerateCustomerTokenFromFacebookParams implements Serializable {

    public String publisherToken;

    public String facebookId;

    public GenerateCustomerTokenFromFacebookParams() {

    }

    public GenerateCustomerTokenFromFacebookParams(String publisherToken, String facebookId) {
        this.publisherToken = publisherToken;
        this.facebookId = facebookId;
    }

    public static GenerateCustomerTokenFromFacebookParams create(String publisherToken, String facebookId) {
        return new GenerateCustomerTokenFromFacebookParams(publisherToken, facebookId);
    }
}
