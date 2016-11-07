package com.cleeng.api.domain;

import java.util.List;

/**
 * Created by Jesion on 2016-11-01.
 */
public class PassOfferResult extends BaseOfferData {

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
    public List<String> accessToTags;
    public String period;
    public long expiresAt;
}
