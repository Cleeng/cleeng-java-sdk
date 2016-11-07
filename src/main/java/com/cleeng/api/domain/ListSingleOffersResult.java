package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jesion on 2016-11-01.
 */
public class ListSingleOffersResult implements Serializable {

    public List<SingleOfferResult> items;

    public int totalItemCount;
}
