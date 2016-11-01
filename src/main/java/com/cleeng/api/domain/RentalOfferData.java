package com.cleeng.api.domain;

import java.util.List;

/**
 * Created by Jesion on 2016-11-01.
 */

public class RentalOfferData extends BaseOfferData {

    public int period;
    public String videoId;
    public String contentExternalId;
    public String contentExternalData;
    public List<String> tags;

    public RentalOfferData(double price,
                           String title,
                           String url,
                           String description,
                           int period,
                           String videoId,
                           String contentExternalId,
                           String contentExternalData,
                           List<String> tags) {
        super( price, title, url, description, false, null, null );

        this.period = period;
        this.videoId = videoId;
        this.contentExternalId = contentExternalId;
        this.contentExternalData = contentExternalData;
        this.tags = tags;
    }

    public RentalOfferData() {

    }
}
