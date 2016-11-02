package com.cleeng.api.domain;

import java.io.Serializable;

/**
 * Created by Jesion on 2016-11-02.
 */
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
