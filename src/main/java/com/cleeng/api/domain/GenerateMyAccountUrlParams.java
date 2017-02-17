package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class GenerateMyAccountUrlParams implements Serializable {

    public String publisherToken;

    public String customerEmail;

    public ArrayList<String> modules;

    public GenerateMyAccountUrlParams(String publisherToken, String customerEmail, ArrayList<String> modules) {

        this.publisherToken = publisherToken;
        this.customerEmail = customerEmail;
        this.modules = modules;
    }
}
