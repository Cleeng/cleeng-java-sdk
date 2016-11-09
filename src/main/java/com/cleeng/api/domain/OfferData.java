package com.cleeng.api.domain;

import java.util.List;

public class OfferData extends BaseOfferDataRequest {

    public String period;
    public int freePeriods;
    public int freeDays;
    public List<String> accessToTags;

    public OfferData() {
        super();
    }

    public OfferData(double price,
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
                     String associateEmail) {
        super(price,
            title,
            url,
            description,
            geoRestrictionEnabled,
            geoRestrictionType,
            geoRestrictionCountries,
            associateEmail
        );
        this.period = period;
        this.freePeriods = freePeriods;
        this.freeDays = freeDays;
        this.accessToTags = accessToTags;
    }
}
