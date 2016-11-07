package com.cleeng.api.domain;

import java.io.Serializable;

public class PrepareRemoteAuthParams implements Serializable {

    public String publisherToken;
    public CustomerData customerData;
    public FlowDescription flowDescription;

    public PrepareRemoteAuthParams() {

    }

    public PrepareRemoteAuthParams( String publisherToken,
                                    CustomerData customerData,
                                    FlowDescription flowDescription ) {
        this.publisherToken = publisherToken;
        this.customerData = customerData;
        this.flowDescription = flowDescription;
    }

    public static PrepareRemoteAuthParams create( String publisherToken,
                                                  CustomerData customerData,
                                                  FlowDescription flowDescription ) {
        return new PrepareRemoteAuthParams( publisherToken, customerData, flowDescription );
    }
}
