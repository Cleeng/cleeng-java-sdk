package com.cleeng.api.domain;

import java.io.Serializable;

public class UpdateCustomerSubscriptionOfferData implements Serializable {

    public String status;
    public String expiresAt;

    public UpdateCustomerSubscriptionOfferData(String status, String expiresAt) {
        this.status = status;
        this.expiresAt = expiresAt;
    }
}
