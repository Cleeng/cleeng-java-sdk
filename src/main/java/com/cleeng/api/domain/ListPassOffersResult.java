package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.List;

public class ListPassOffersResult implements Serializable {

    public List<PassOfferResult> items;

    public int totalItemCount;
}
