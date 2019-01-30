package com.cleeng.api.domain;

import java.io.Serializable;

public class PersonalData implements Serializable {

    public String firstName;
    public String address;
    public String country;

    public PersonalData() {

    }

    public PersonalData(String firstName, String address, String country) {
        this.firstName = firstName;
        this.address = address;
        this.country = country;
    }
}
