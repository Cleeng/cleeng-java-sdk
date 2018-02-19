package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCRequest;

public class GetPaymentDetailsRequest extends JSONRPCRequest {

    public GetPaymentDetailsRequest(String method, PaymentDetailsParams params) {
        super("1", "2.0");
        this.method = method;
        this.params = params;
    }

}