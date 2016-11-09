package com.cleeng.api.domain;

import java.util.List;
import java.util.Map;

public class EventOfferResult extends BaseOfferData {

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
    public String currency;
    public String playerCode;
    public String playerCodeHead;
    public long startTime;
    public long endTime;
    public String timeZone;
    public String videoId;
    public String viewerEstimate;
    public String teaser;
    public boolean applyServiceFeeOnCustomer;
    public List<String> tags;
    public Map<String, String> backgroundImageUrl;

}
