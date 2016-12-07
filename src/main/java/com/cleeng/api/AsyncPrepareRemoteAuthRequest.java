package com.cleeng.api;

import com.cleeng.api.domain.CustomerData;
import com.cleeng.api.domain.FlowDescription;

public class AsyncPrepareRemoteAuthRequest extends AsyncRequest {

    public CustomerData customerData;

    public FlowDescription flowDescription;

    public AsyncPrepareRemoteAuthRequest( CustomerData customerData, FlowDescription flowDescription, AsyncRequestCallback callback ) {

        super();

        this.callback = callback;
        this.customerData = customerData;
        this.flowDescription = flowDescription;
    }
}
