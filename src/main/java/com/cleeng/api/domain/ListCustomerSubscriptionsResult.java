package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.List;

public class ListCustomerSubscriptionsResult implements Serializable {

    public List<CustomerSubscription> items;

    public int totalItemCount;

}
