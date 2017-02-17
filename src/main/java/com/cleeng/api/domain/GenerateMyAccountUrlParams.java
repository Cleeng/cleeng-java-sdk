package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.List;

public class GenerateMyAccountUrlParams implements Serializable {

    public String publisherToken;

    public String customerEmail;

    public List<String> modules;

    public GenerateMyAccountUrlParams(String publisherToken, String customerEmail, List<String> modules) {

        this.publisherToken = publisherToken;
        this.customerEmail = customerEmail;
        this.modules = modules;
    }

    public GenerateMyAccountUrlParams(String customerEmail, List<String> modules) {

        this.customerEmail = customerEmail;
        this.modules = modules;
    }
}
