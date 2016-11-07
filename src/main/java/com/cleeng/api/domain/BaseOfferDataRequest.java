package com.cleeng.api.domain;

import java.util.List;

public class BaseOfferDataRequest extends BaseOfferData {

    public String associateEmail;

    public BaseOfferDataRequest(double price,
                                String title,
                                String url,
                                String description,
                                boolean geoRestrictionEnabled,
                                String geoRestrictionType,
                                List<String> geoRestrictionCountries,
                                String associateEmail) {
        super( price,
            title,
            url,
            description,
            geoRestrictionEnabled,
            geoRestrictionType,
            geoRestrictionCountries
        );
        this.associateEmail = associateEmail;
    }

    public BaseOfferDataRequest() {

    }
}
