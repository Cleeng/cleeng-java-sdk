package com.cleeng.api.domain;

import java.util.List;

public class EventOfferData extends BaseOfferDataRequest {

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

    public EventOfferData(double price,
                          String currency,
                          String title,
                          String url,
                          String description,
                          String playerCode,
                          String playerCodeHead,
                          long startTime,
                          long endTime,
                          String timeZone,
                          String videoId,
                          String viewerEstimate,
                          String teaser,
                          boolean applyServiceFeeOnCustomer,
                          List<String> tags,
                          boolean geoRestrictionEnabled,
                          String geoRestrictionType,
                          List<String> geoRestrictionCountries,
                          String associateEmail) {
        super( price,
            title,
            url,
            description,
            geoRestrictionEnabled,
            geoRestrictionType,
            geoRestrictionCountries,
            associateEmail
        );
        this.currency = currency;
        this.playerCode = playerCode;
        this.playerCodeHead = playerCodeHead;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeZone = timeZone;
        this.videoId = videoId;
        this.viewerEstimate = viewerEstimate;
        this.teaser = teaser;
        this.applyServiceFeeOnCustomer = applyServiceFeeOnCustomer;
        this.tags = tags;
    }

    public EventOfferData() {

    }
}
