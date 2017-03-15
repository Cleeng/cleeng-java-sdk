package com.cleeng.api.domain;

import com.google.gson.internal.LinkedTreeMap;

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

    public OfferResult(LinkedTreeMap<String, String> input) {

        //TODO: check if there is a better option...
        this.id = input.get("id");
        this.publisherEmail = input.get("publisherEmail");
    }
}
