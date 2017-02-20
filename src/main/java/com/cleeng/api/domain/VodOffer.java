package com.cleeng.api.domain;

import java.io.Serializable;
import java.util.List;

public class VodOffer implements Serializable {

    public String url;
    public double price;
    public String createdAt;
    public double applicableTaxRate;
    public String description;
    public String background;
    public String title;
    public List<String> tags;
    public String currency;
    public String updatedAt;
    public String id;
    public String shortUrl;
    public String publisherEmail;

    public VodOffer() {

    }
}
