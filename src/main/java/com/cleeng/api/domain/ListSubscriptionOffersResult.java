package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.List;

public class ListSubscriptionOffersResult implements Serializable {

    public List<OfferResult> items;

    public int totalItemCount;
}
