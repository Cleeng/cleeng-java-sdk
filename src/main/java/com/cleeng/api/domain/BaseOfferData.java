package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.List;

public class BaseOfferData implements Serializable {

    public double price;
    public String title;
    public String url;
    public String description;
    public boolean geoRestrictionEnabled;
    public String geoRestrictionType;
    public List<String> geoRestrictionCountries;

    public BaseOfferData(double price,
                         String title,
                         String url,
                         String description,
                         boolean geoRestrictionEnabled,
                         String geoRestrictionType,
                         List<String> geoRestrictionCountries) {
        this.price = price;
        this.title = title;
        this.url = url;
        this.description = description;
        this.geoRestrictionEnabled = geoRestrictionEnabled;
        this.geoRestrictionType = geoRestrictionType;
        this.geoRestrictionCountries = geoRestrictionCountries;
    }

    public BaseOfferData() {

    }
}
