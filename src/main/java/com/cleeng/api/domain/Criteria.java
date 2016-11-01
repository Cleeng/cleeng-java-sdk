package com.cleeng.api.domain;

import java.io.Serializable;

/**
 * Created by Jesion on 2016-11-01.
 */
public class Criteria implements Serializable {

    public boolean active;

    public Criteria() {

    }

    public Criteria(boolean active) {
        this.active = active;
    }
}
