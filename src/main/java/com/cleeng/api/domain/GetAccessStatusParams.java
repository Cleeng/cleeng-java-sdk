package com.cleeng.api.domain;

import java.io.Serializable;

public class GetAccessStatusParams implements Serializable {

    public String customerToken;
    public String offerId;
    public String ipAddress;

    public GetAccessStatusParams() {

    }

    public GetAccessStatusParams(String customerToken, String offerId, String ipAddress) {
        this.customerToken = customerToken;
        this.offerId = offerId;
        this.ipAddress = ipAddress;
    }
}
