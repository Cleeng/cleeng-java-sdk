package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jesion on 2016-10-31.
 */
public class BaseOfferData implements Serializable {

    public double price;
    public String title;
    public String url;
    public String description;
    public boolean geoRestrictionEnabled;
    public String geoRestrictionType;
    public List<String> geoRestrictionCountries;
    public String associateEmail;

    public BaseOfferData( double price,
                          String title,
                          String url,
                          String description,
                          boolean geoRestrictionEnabled,
                          String geoRestrictionType,
                          List<String> geoRestrictionCountries,
                          String associateEmail ) {
        this.price = price;
        this.title = title;
        this.url = url;
        this.description = description;
        this.geoRestrictionEnabled = geoRestrictionEnabled;
        this.geoRestrictionType = geoRestrictionType;
        this.geoRestrictionCountries = geoRestrictionCountries;
        this.associateEmail = associateEmail;
    }

    public BaseOfferData() {

    }
}
