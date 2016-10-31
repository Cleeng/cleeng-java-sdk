package com.cleeng.api.domain;

import java.util.List;

/**
 * Created by Jesion on 2016-10-31.
 */
public class EventOfferDataRequest extends EventOfferData {

    public String backgroundImageUrl;

    public EventOfferDataRequest(double price,
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
                          String backgroundImageUrl) {
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
            geoRestrictionCountries);

        this.backgroundImageUrl = backgroundImageUrl;
    }
}
