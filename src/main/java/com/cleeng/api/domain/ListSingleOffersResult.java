package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.List;

public class ListSingleOffersResult implements Serializable {

    public List<SingleOfferResult> items;

    public int totalItemCount;
}
