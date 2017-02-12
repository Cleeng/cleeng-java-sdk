package com.cleeng.api.domain;

import java.io.Serializable;

public class GenerateCustomerTokenFromPasswordParams implements Serializable {

    public String publisherToken;

    public String password;

    public GenerateCustomerTokenFromPasswordParams() {

    }

    public GenerateCustomerTokenFromPasswordParams(String publisherToken, String password) {
        this.publisherToken = publisherToken;
        this.password = password;
    }

    public static GenerateCustomerTokenFromPasswordParams create(String publisherToken, String password) {
        return new GenerateCustomerTokenFromPasswordParams(publisherToken, password);
    }
}
