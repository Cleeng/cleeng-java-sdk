package com.cleeng.api.domain;

import java.io.Serializable;

public class PaymentDetailsResult implements Serializable {

    public String lastFourCardDigits;
    public String expirationDate;
    public String paymentMethod;

}
