package com.cleeng.api.domain;

import java.io.Serializable;

public class GetAccessStatusForDeviceResult implements Serializable {

    public boolean accessGranted;
    public String grantType;
    public String expiresAt;
    public boolean purchasedDirectly;
}