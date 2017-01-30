package com.cleeng.api.domain;

import java.util.List;

/*
example request:
[
  {
    "method": "createVodOffer",
    "params": {
      "publisherToken": "IEiuf3fJzAorVvxgBYiHiHXGk8oFPckTMSOn8hS1--lOti30",
      "offerData": {
        "price": "9",
        "title": "yiuyiu",
        "url": "http:\/\/www.wp.pl",
        "description": "iuyiuy",
        "videoId": "iuyiu",
        "playerCode": "yiuy",
        "playerCodeHead": "iuyi",
        "rentalPeriod": "7",
        "runtime": "7",
        "videoQuality": "hd",
        "backgroundImageUrl": "http:\/\/www.wp.pl",
        "geoRestrictionEnabled": "true",
        "geoRestrictionType": "whitelist",
        "geoRestrictionCountries": [
          "pl",
          "de"
        ]
      }
    },
    "jsonrpc": "2.0",
    "id": 1
  }
]
*/

public class VodOfferData extends BaseOfferDataRequest {

    public String videoId;
    public String playerCode;
    public String playerCodeHead;
    public String rentalPeriod;
    public String runtime;
    public String videoQuality;
    public List<String> eventAssociation;
    public List<String> tags;
    public String backgroundImageUrl;

    public VodOfferData() {

    }

    public VodOfferData(double price,
                        String title,
                        String url,
                        String description,
                        String associateEmail,
                        String videoId,
                        String playerCode,
                        String playerCodeHead,
                        String rentalPeriod,
                        String runtime,
                        String videoQuality,
                        List<String> eventAssociation,
                        List<String> tags,
                        List<String> geoRestrictionCountries,
                        boolean geoRestrictionEnabled,
                        String geoRestrictionType,
                        String backgroundImageUrl) {

        super( price,
                title,
                url,
                description,
                geoRestrictionEnabled,
                geoRestrictionType,
                geoRestrictionCountries,
                associateEmail
        );

        this.videoId = videoId;
        this.playerCode = playerCode;
        this.playerCodeHead = playerCodeHead;
        this.rentalPeriod = rentalPeriod;
        this.runtime = runtime;
        this.videoQuality = videoQuality;
        this.eventAssociation = eventAssociation;
        this.tags = tags;
        this.backgroundImageUrl = backgroundImageUrl;
    }
}
