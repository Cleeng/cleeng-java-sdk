package com.cleeng.api.domain;

import java.io.Serializable;

/**
 * Created by Jesion on 2016-11-02.
 */
public class GetAccessStatusResult implements Serializable {

    public boolean accessGranted;
    public String grantType;
    public long expiresAt;
    public boolean purchasedDirectly;

}