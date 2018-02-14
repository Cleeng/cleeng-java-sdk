package com.cleeng.api.domain;

import java.io.Serializable;

public class UpdateCustomerSubscriptionParams implements Serializable {

    public String publisherToken;
    public String customerEmail;
    public String offerId;
    public UpdateCustomerSubscriptionOfferData subscriptionData;

    public UpdateCustomerSubscriptionParams(String publisherToken,
                                            String customerEmail,
                                            String offerId,
                                            UpdateCustomerSubscriptionOfferData subscriptionData) {
        this.publisherToken = publisherToken;
        this.customerEmail = customerEmail;
        this.offerId = offerId;
        this.subscriptionData = subscriptionData;
    }

    public UpdateCustomerSubscriptionParams(String customerEmail,
                                            String offerId,
                                            UpdateCustomerSubscriptionOfferData subscriptionData) {
        this.customerEmail = customerEmail;
        this.offerId = offerId;
        this.subscriptionData = subscriptionData;
    }
}
