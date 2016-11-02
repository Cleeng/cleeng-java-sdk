package com.cleeng.api.domain;

import java.io.Serializable;

/**
 * Created by Jesion on 2016-11-02.
 */
public class CustomerData implements Serializable {

    public String email;
    public String locale;
    public String currency;
    public String country;

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
}
