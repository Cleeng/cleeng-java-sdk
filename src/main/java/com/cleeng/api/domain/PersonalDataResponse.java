package com.cleeng.api.domain;

import org.jsonrpc.JSONRPCMessage;

public class PersonalDataResponse extends JSONRPCMessage {

    public PersonalData result;

    public PersonalDataResponse() {

    }

    public PersonalDataResponse(PersonalData result) {

        this.result = result;
    }
}
