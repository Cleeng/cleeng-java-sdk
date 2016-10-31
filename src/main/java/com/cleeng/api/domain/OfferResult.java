package com.cleeng.api.domain;

/**
 * Created by Jesion on 2016-10-29.
 */

public class OfferResult extends OfferData {

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
    public long expiresAt;

    public OfferResult() {

    }
}
