package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

public class PersonalDataResponse extends JSONRPCMessage {

    public PersonalDataResult result;

    public PersonalDataResponse() {

    }

    public PersonalDataResponse(PersonalDataResult result) {

        this.result = result;
    }
}
