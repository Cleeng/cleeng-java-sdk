package com.cleeng.api.domain;

import java.io.Serializable;

/**
 * Created by Jesion on 2016-11-02.
 */
public class PrepareRemoteAuthResult implements Serializable {

    public String url;

    public PrepareRemoteAuthResult(String url) {
        this.url = url;
    }

    public PrepareRemoteAuthResult() {

    }
}
