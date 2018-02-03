package com.cleeng.api.domain;

import java.io.Serializable;

public class PaymentDetailsParams implements Serializable {

    public String publisherToken;
    public String userEmail;
    public String offerId;

    public PaymentDetailsParams(String publisherToken, String userEmail, String offerId) {

        this.publisherToken = publisherToken;
        this.userEmail = userEmail;
        this.offerId = offerId;
    }

    public static PaymentDetailsParams create(String publisherToken, String userEmail, String offerId) {
        return new PaymentDetailsParams(publisherToken, userEmail, offerId);
    }
}