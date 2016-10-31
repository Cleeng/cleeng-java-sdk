package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jesion on 2016-10-29.
 */

public class OfferData implements Serializable {

    public double price;
    public String period;
    public String title;
    public String url;
    public String description;
    public int freePeriods;
    public int freeDays;
    public List<String> accessToTags;
    public boolean geoRestrictionEnabled;
    public String geoRestrictionType;
    public List<String> geoRestrictionCountries;

    public OfferData() {

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
        this.price = price;
        this.period = period;
        this.title = title;
        this.url = url;
        this.description = description;
        this.freePeriods = freePeriods;
        this.freeDays = freeDays;
        this.accessToTags = accessToTags;
        this.geoRestrictionEnabled = geoRestrictionEnabled;
        this.geoRestrictionType = geoRestrictionType;
        this.geoRestrictionCountries = geoRestrictionCountries;
    }
}
