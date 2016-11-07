package com.cleeng.api.domain;

import java.util.List;

public class PassOfferData extends BaseOfferDataRequest {

    public List<String> accessToTags;
    public String period;
    public long expiresAt;

    public PassOfferData() {

    }

    public PassOfferData(double price,
                         String period,
                         long expiresAt,
                         String title,
                         String url,
                         String associateEmail,
                         String description,
                         List<String> accessToTags,
                         boolean geoRestrictionEnabled,
                         String geoRestrictionType,
                         List<String> geoRestrictionCountries
                        ) {
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
