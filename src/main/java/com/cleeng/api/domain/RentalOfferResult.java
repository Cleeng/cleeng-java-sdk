package com.cleeng.api.domain;

/**
 * Created by Jesion on 2016-11-01.
 */
public class RentalOfferResult extends RentalOfferData {

    public String id;
    public String publisherEmail;
    public String country;
    public boolean active;
    public long createdAt;
    public long updatedAt;
    public double applicableTaxRate;
    public int socialCommissionRate;
    public int averageRating;
    public String contentType;
    public String contentAgeRestriction;
}
