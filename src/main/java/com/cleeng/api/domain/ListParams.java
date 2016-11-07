package com.cleeng.api.domain;

import java.io.Serializable;

public class ListParams implements Serializable {

    public String publisherToken;
    public Criteria criteria;
    public int offset;
    public int limit;

    public ListParams(String publisherToken, Criteria criteria, int offset, int limit) {

        this.publisherToken = publisherToken;
        this.criteria = criteria;
        this.offset = offset;
        this.limit = limit;
    }

    public static ListParams create(String publisherToken, Criteria criteria, int offset, int limit) {
        return new ListParams(publisherToken, criteria, offset, limit);
    }
}
