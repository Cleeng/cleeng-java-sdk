package com.cleeng.api.domain;

import java.util.List;

public class EventOfferDataRequest extends EventOfferData {

    public String backgroundImageUrl;

    public EventOfferDataRequest(double price,
                          String currency,
                          String title,
                          String url,
                          String description,
                          String playerCode,
                          String playerCodeHead,
                          String backgroundImageUrl,
                          long startTime,
                          long endTime,
                          String timeZone,
                          String associateEmail,
                          String videoId,
                          String viewerEstimate,
                          String teaser,
                          boolean applyServiceFeeOnCustomer,
                          List<String> tags,
                          boolean geoRestrictionEnabled,
                          String geoRestrictionType,
                          List<String> geoRestrictionCountries) {
        super(price,
            currency,
            title,
            url,
            description,
            playerCode,
            playerCodeHead,
            startTime,
            endTime,
            timeZone,
            videoId,
            viewerEstimate,
            teaser,
            applyServiceFeeOnCustomer,
            tags,
            geoRestrictionEnabled,
            geoRestrictionType,
            geoRestrictionCountries,
            associateEmail
        );

        this.backgroundImageUrl = backgroundImageUrl;
    }
}
