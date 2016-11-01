package com.cleeng.api.domain;

import java.io.Serializable;

/**
 * Created by Jesion on 2016-11-01.
 */
public class ListParams implements Serializable {

    public String publisherToken;
    public Criteria criteria;

    public ListParams(String publisherToken, Criteria criteria) {

        this.publisherToken = publisherToken;
        this.criteria = criteria;
    }

    public static ListParams create(String publisherToken, Criteria criteria) {
        return new ListParams(publisherToken, criteria);
    }
}
