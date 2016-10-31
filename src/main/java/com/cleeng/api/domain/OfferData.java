package com.cleeng.api.domain;

import java.util.List;

/**
 * Created by Jesion on 2016-10-29.
 */

public class OfferData extends BaseOfferData {

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
                     List<String> geoRestrictionCountries) {
        super(price,
            title,
            url,
            description,
            geoRestrictionEnabled,
            geoRestrictionType,
            geoRestrictionCountries
        );
        this.period = period;
        this.freePeriods = freePeriods;
        this.freeDays = freeDays;
        this.accessToTags = accessToTags;
    }
}
