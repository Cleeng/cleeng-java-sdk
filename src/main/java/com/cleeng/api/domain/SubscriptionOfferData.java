package com.cleeng.api.domain;

import java.util.List;

/**
 * Created by Jesion on 2016-11-05.
 */
public class SubscriptionOfferData extends BaseOfferData {

    public String period;
    public int freePeriods;
    public int freeDays;
    public List<String> accessToTags;

    public SubscriptionOfferData(double price,
                                 String period,
                                 String title,
                                 String url,
                                 String description,
                                 String associateEmail,
                                 int freePeriods,
                                 int freeDays,
                                 List<String> accessToTags,
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

        this.period = period;
        this.freeDays = freeDays;
        this.freePeriods = freePeriods;
        this.accessToTags = accessToTags;
    }
}
