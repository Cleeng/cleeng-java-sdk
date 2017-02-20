package com.cleeng.api.domain;

import java.io.Serializable;

public class GenerateCustomerTokenFromPasswordParams implements Serializable {

    public String publisherToken;

    public String password;

    public String customerEmail;

    public GenerateCustomerTokenFromPasswordParams() {

    }

    public GenerateCustomerTokenFromPasswordParams(String publisherToken, String password, String customerEmail) {
        this.publisherToken = publisherToken;
        this.password = password;
        this.customerEmail = customerEmail;
    }

    public static GenerateCustomerTokenFromPasswordParams create(String publisherToken, String password, String customerEmail) {
        return new GenerateCustomerTokenFromPasswordParams(publisherToken, password, customerEmail);
    }
}
