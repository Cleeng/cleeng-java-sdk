package com.cleeng.api.domain;

import java.io.Serializable;

public class PaymentDetailsResult implements Serializable {

    public String paymentDetailsId;
    public String paymentGateway;
    public String paymentMethod;
    public String cardExpirationDate;
    public String cardLastFourDigits;

}
