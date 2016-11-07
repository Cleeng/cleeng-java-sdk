package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jesion on 2016-11-01.
 */
public class ListPassOffersResult implements Serializable {

    public List<PassOfferResult> items;

    public int totalItemCount;
}
