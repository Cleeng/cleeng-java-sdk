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
/*

[
  {
    "result": {
      "vod": {
        "id": "R262528011_PL",
        "title": "yiuyiu",
        "description": "iuyiuy",
        "url": "http:\/\/www.wp.pl",
        "price": "7.3170",
        "videoId": "iuyiu",
        "rentalPeriod": "7",
        "publisherEmail": "jesionekdev@gmail.com",
        "playerCode": "yiuy",
        "playerCodeHead": "iuyi",
        "streamingPlatform": null,
        "runtime": "7",
        "videoQuality": "hd",
        "backgroundImageUrl": {
          "small": "http:\/\/www.wp.pl",
          "medium": "http:\/\/www.wp.pl",
          "large": "http:\/\/www.wp.pl"
        },
        "eventAssociation": [

        ],
        "geoRestrictionEnabled": true,
        "geoRestrictionType": "whitelist",
        "geoRestrictionCountries": [
          "pl",
          "de"
        ],
        "tags": [

        ]
      }
    },
    "id": "1",
    "jsonrpc": "2.0"
  }
]
*/
