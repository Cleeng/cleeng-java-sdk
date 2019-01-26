package com.cleeng.api.domain;

import java.io.Serializable;

public class PersonalDataParams implements Serializable {

    public String publisherToken;
    public String userId;
    public PersonalData newPersonalData;

    public PersonalDataParams() {

    }

    public PersonalDataParams(String publisherToken, String userId, PersonalData newPersonalData) {
        this.publisherToken = publisherToken;
        this.userId = userId;
        this.newPersonalData = newPersonalData;
    }
}
