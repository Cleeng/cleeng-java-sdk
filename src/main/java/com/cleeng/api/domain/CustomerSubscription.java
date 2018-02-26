package com.cleeng.api.domain;

import java.io.Serializable;

public class CustomerSubscription implements Serializable {

    public String offerId;
    public String status;
    public double expiresAt;
    public double nextPaymentPrice;
    public String nextPaymentCurrency;
    public String paymentGateway;
    public String paymentMethod;

}

