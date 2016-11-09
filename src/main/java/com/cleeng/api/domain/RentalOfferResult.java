package com.cleeng.api.domain;

import java.util.List;

public class RentalOfferResult extends BaseOfferData {

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
    public int period;
    public String videoId;
    public String contentExternalId;
    public String contentExternalData;
    public List<String> tags;
    public String currency;
}
