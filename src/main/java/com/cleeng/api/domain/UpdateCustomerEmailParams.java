package com.cleeng.api.domain;

import java.io.Serializable;

public class UpdateCustomerEmailParams implements Serializable {

    public String publisherToken;

    public String customerEmail;

    public String newEmail;

    public UpdateCustomerEmailParams(String customerEmail, String newEmail) {

        this.customerEmail = customerEmail;
        this.newEmail = newEmail;
    }

    public UpdateCustomerEmailParams(String publisherToken, String customerEmail, String newEmail) {

        this.publisherToken = publisherToken;
        this.customerEmail = customerEmail;
        this.newEmail = newEmail;
    }
}

