package com.cleeng.api.domain;

import java.util.List;
import java.util.Map;

public class Vod extends BaseOfferData {

    public String id;
    public String videoId;
    public String rentalPeriod;
    public String publisherEmail;
    public String playerCode;
    public String playerCodeHead;
    public String streamingPlatform;
    public String runtime;
    public String videoQuality;
    public Map<String, String> backgroundImageUrl;
    public List<String> eventAssociation;
    public List<String> tags;

    public Vod() {

    }
    public Vod(String id,
               String title,
               String description,
               String url,
               double price,
               String videoId,
               String rentalPeriod,
               String publisherEmail,
               String playerCode,
               String playerCodeHead,
               String streamingPlatform,
               String runtime,
               String videoQuality,
               Map<String, String> backgroundImageUrl,
               List<String> eventAssociation,
               boolean geoRestrictionEnabled,
               String geoRestrictionType,
               List<String> geoRestrictionCountries,
               List<String> tags) {
        super(price,
            title,
            url,
            description,
            geoRestrictionEnabled,
            geoRestrictionType,
            geoRestrictionCountries
        );
        this.id = id;
        this.videoId = videoId;
        this.rentalPeriod = rentalPeriod;
        this.publisherEmail = publisherEmail;
        this.playerCode = playerCode;
        this.playerCodeHead = playerCodeHead;
        this.streamingPlatform = streamingPlatform;
        this.runtime = runtime;
        this.videoQuality = videoQuality;
        this.backgroundImageUrl = backgroundImageUrl;
        this.eventAssociation = eventAssociation;
        this.tags = tags;
    }
}
