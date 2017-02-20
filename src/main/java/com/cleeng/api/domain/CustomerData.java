package com.cleeng.api.domain;

import java.io.Serializable;

public class CustomerData implements Serializable {

    public String email;
    public String locale;
    public String currency;
    public String country;
    public String password;
    public String facebookId;

    public CustomerData() {

    }

    public CustomerData(String email,
                        String locale,
                        String currency,
                        String country) {
        this.email = email;
        this.locale = locale;
        this.currency = currency;
        this.country = country;
    }

    public CustomerData(String email,
                        String locale,
                        String currency,
                        String country,
                        String password) {
        this.email = email;
        this.locale = locale;
        this.currency = currency;
        this.country = country;
        this.password = password;
    }

    public CustomerData(String email,
                        String locale,
                        String currency,
                        String country,
                        String password,
                        String facebookId) {
        this.email = email;
        this.locale = locale;
        this.currency = currency;
        this.country = country;
        this.password = password;
        this.facebookId = facebookId;
    }
}
