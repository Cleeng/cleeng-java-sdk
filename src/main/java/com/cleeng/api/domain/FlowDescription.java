package com.cleeng.api.domain;

import java.io.Serializable;

/**
 * Created by Jesion on 2016-11-02.
 */
public class FlowDescription implements Serializable {

    public int offerId;
    public String url;

    public FlowDescription() {

    }

    public FlowDescription(int offerId, String url) {
        this.offerId = offerId;
        this.url = url;
    }
}
