package com.cleeng.api.domain;

/**
 * Created by Jesion on 2016-10-31.
 */

public class EventOfferResult extends EventOfferData {

    public String id;
    public String publisherEmail;
    public String country;
    public boolean active;
    public long createdAt;
    public long updatedAt;
    public int applicableTaxRate;
    public int socialCommissionRate;
    public int averageRating;
    public String contentType;
}
