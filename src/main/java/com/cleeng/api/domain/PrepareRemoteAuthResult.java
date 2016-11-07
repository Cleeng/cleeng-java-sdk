package com.cleeng.api.domain;

import java.io.Serializable;

public class PrepareRemoteAuthResult implements Serializable {

    public String url;

    public PrepareRemoteAuthResult(String url) {
        this.url = url;
    }

    public PrepareRemoteAuthResult() {

    }
}
