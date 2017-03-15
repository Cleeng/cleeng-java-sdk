package com.cleeng.api.domain;

import java.util.List;

public class OfferResult extends BaseOfferData {

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
    public String period;
    public int freePeriods;
    public int freeDays;
    public List<String> accessToTags;

    public OfferResult() {

    }
}
