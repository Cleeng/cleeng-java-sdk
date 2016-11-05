package com.cleeng.api.domain;

import java.util.List;

/**
 * Created by Jesion on 2016-11-01.
 */
public class PassOfferData extends BaseOfferData {

    public List<String> accessToTags;
    public String period;
    public long expiresAt;

    public PassOfferData() {

    }

    public PassOfferData(double price,
                         String title,
                         String url,
                         String description,
                         boolean geoRestrictionEnabled,
                         String geoRestrictionType,
                         List<String> geoRestrictionCountries,
                         List<String> accessToTags,
                         String period,
                         long expiresAt,
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
        this.accessToTags = accessToTags;
        this.period = period;
        this.expiresAt = expiresAt;
    }
}
