package com.cleeng.api.domain;

import java.io.Serializable;

public class IsTrialAllowedParams implements Serializable {

    public String publisherToken;
    public String customerEmail;
    public String offerId;

    public IsTrialAllowedParams(String publisherToken, String customerEmail, String offerId) {
        this.publisherToken = publisherToken;
        this.customerEmail = customerEmail;
        this.offerId = offerId;
    }

    public IsTrialAllowedParams(String customerEmail, String offerId) {
        this.customerEmail = customerEmail;
        this.offerId = offerId;
    }
}
