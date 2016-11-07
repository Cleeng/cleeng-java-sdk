package com.cleeng.api.domain;

import java.io.Serializable;

public class GetAccessStatusResult implements Serializable {

    public boolean accessGranted;
    public String grantType;
    public long expiresAt;
    public boolean purchasedDirectly;

}