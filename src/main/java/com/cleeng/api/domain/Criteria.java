package com.cleeng.api.domain;

import java.io.Serializable;

/**
 * Created by Jesion on 2016-11-01.
 */
public class Criteria implements Serializable {

    public boolean active;
    public int offset;
    public int limit;

    public Criteria() {

    }

    public Criteria(boolean active, int offset, int limit) {
        this.active = active;
        this.offset = offset;
        this.limit = limit;
    }
}
