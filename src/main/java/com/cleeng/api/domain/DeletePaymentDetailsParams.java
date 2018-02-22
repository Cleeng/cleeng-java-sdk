package com.cleeng.api.domain;

import java.io.Serializable;

public class DeletePaymentDetailsParams implements Serializable {

    public String publisherToken;
    public String paymentDetailsId;

    public DeletePaymentDetailsParams(String publisherToken, String paymentDetailsId) {

        this.publisherToken = publisherToken;
        this.paymentDetailsId = paymentDetailsId;
    }

    public DeletePaymentDetailsParams(String paymentDetailsId) {
        this.paymentDetailsId = paymentDetailsId;
    }

    public static PaymentDetailsParams create(String publisherToken, String paymentDetailsId) {
        return new PaymentDetailsParams(publisherToken, paymentDetailsId);
    }
}