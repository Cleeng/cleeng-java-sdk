package com.cleeng.api.domain;

import java.io.Serializable;

public class PaymentDetailsParams implements Serializable {

    public String publisherToken;
    public String userEmail;

    public PaymentDetailsParams(String publisherToken, String userEmail) {

        this.publisherToken = publisherToken;
        this.userEmail = userEmail;
    }

    public PaymentDetailsParams(String userEmail) {
        this.userEmail = userEmail;
    }

    public static PaymentDetailsParams create(String publisherToken, String userEmail) {
        return new PaymentDetailsParams(publisherToken, userEmail);
    }
}