package com.cleeng.api.domain;

import java.util.List;

/**
 * Created by Jesion on 2016-10-29.
 */

public class SingleOfferData extends BaseOfferData {

    public String videoId;
    public String contentExternalId;
    public String contentExternalData;
    public List<String> tags;

    public SingleOfferData(double price,
                     String title,
                     String url,
                     String description,
                     String associateEmail,
                     String videoId,
                     String contentExternalId,
                     String contentExternalData,
                     List<String> tags,
                     boolean geoRestrictionEnabled,
                     String geoRestrictionType,
                     List<String> geoRestrictionCountries) {
        super( price,
            title,
            url,
            description,
            geoRestrictionEnabled,
            geoRestrictionType,
            geoRestrictionCountries,
            associateEmail
        );
        this.videoId = videoId;
        this.contentExternalId = contentExternalId;
        this.contentExternalData = contentExternalData;
        this.tags = tags;
    }
}
