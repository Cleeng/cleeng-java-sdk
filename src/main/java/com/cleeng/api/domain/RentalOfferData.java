package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.List;

public class RentalOfferData implements Serializable {

    public int period;
    public String videoId;
    public String contentExternalId;
    public String contentExternalData;
    public List<String> tags;
    public String associateEmail;
    public double price;
    public String title;
    public String url;
    public String description;

    public RentalOfferData(double price,
                           String title,
                           int period,
                           String url,
                           String description,
                           String associateEmail,
                           String videoId,
                           String contentExternalId,
                           String contentExternalData,
                           List<String> tags) {

        this.price = price;
        this.title = title;
        this.url = url;
        this.description = description;
        this.period = period;
        this.videoId = videoId;
        this.contentExternalId = contentExternalId;
        this.contentExternalData = contentExternalData;
        this.associateEmail = associateEmail;
        this.tags = tags;
    }

    public RentalOfferData() {

    }
}
