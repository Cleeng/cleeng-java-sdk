package com.cleeng.api.domain;

import java.io.Serializable;

public class UserParams implements Serializable {

    public String publisherToken;
    public Integer userId;

    public UserParams() {

    }

    public UserParams(String publisherToken, Integer userId) {
        this.publisherToken = publisherToken;
        this.userId = userId;
    }
}
