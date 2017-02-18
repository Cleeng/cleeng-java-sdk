package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.List;

public class ListVodOffersResult implements Serializable {

    public List<VodOffer> items;

    public int totalItemCount;
}
