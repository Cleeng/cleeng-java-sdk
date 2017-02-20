package com.cleeng.api.domain;

import java.io.Serializable;

public class GetAccessStatusForDeviceParams implements Serializable {

    public String customerToken;
    public String offerId;
    public String deviceId;
    public String deviceType;

    public GetAccessStatusForDeviceParams(String customerToken,
                                          String offerId,
                                          String deviceId,
                                          String deviceType) {
        this.customerToken = customerToken;
        this.offerId = offerId;
        this.deviceId = deviceId;
        this.deviceType = deviceType;
    }
}
