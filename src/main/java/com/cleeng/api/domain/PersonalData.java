package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class PersonalData implements Serializable {

    public String firstName;
    public String lastName;
    public String address;
    public String address2;
    public String city;
    public String postCode;
    public String country;
    public String email;
    public String birthDate;
    public String companyName;
    public String phoneNumber;
    public Integer broadcasterId;
    public ArrayList<Answer> customAnswers;

    public PersonalData() {

    }

    public PersonalData(String firstName,
                        String lastName,
                        String address,
                        String address2,
                        String city,
                        String postCode,
                        String country,
                        String email,
                        String birthDate,
                        String companyName,
                        String phoneNumber,
                        Integer broadcasterId,
                        ArrayList<Answer> customAnswers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.address2 = address2;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
        this.email = email;
        this.birthDate = birthDate;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.broadcasterId = broadcasterId;
        this.customAnswers = customAnswers;
    }
}
