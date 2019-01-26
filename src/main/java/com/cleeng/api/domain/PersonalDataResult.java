package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class PersonalDataResult implements Serializable {

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
    public ArrayList<String> customAnswers;

}

