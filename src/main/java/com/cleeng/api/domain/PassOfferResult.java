package com.cleeng.api.domain;

/**
 * Created by Jesion on 2016-11-01.
 */
public class PassOfferResult extends PassOfferData {

    public String id;
    public String publisherEmail;
    public String country;
    public String currency;
    public boolean active;
    public long createdAt;
    public long updatedAt;
    public double applicableTaxRate;
    public int socialCommissionRate;
    public int averageRating;
    public String contentType;
}
