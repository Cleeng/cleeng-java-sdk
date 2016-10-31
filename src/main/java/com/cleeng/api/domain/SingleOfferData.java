package com.cleeng.api.domain;

import java.util.List;

/**
 * Created by Jesion on 2016-10-29.
 */
public class SingleOfferData extends OfferData {

    public String videoId;
    public String contentExternalId;
    public String contentExternalData;
    public List<String> tags;

    public SingleOfferData(double price,
                     String period,
                     String title,
                     String url,
                     String description,
                     int freePeriods,
                     int freeDays,
                     List<String> accessToTags,
                     boolean geoRestrictionEnabled,
                     String geoRestrictionType,
                     List<String> geoRestrictionCountries,
                     String videoId,
                     String contentExternalId,
                     String contentExternalData,
                     List<String> tags) {
        super( price,
               period,
               title,
               url,
               description,
               freePeriods,
               freeDays,
               accessToTags,
               geoRestrictionEnabled,
               geoRestrictionType,
               geoRestrictionCountries );
        this.videoId = videoId;
        this.contentExternalId = contentExternalId;
        this.contentExternalData = contentExternalData;
        this.tags = tags;
    }
}
