package com.cleeng.api.domain;

import java.io.Serializable;

public class FlowDescription implements Serializable {

    public String offerId;
    public String url;

    public FlowDescription() {

    }

    public FlowDescription(String offerId, String url) {
        this.offerId = offerId;
        this.url = url;
    }
}
