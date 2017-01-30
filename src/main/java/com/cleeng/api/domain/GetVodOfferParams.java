package com.cleeng.api.domain;

import java.io.Serializable;

public class GetVodOfferParams implements Serializable {

    public String publisherToken;

    public String offerIdString;

    public GetVodOfferParams() {

    }

    public GetVodOfferParams(String publisherToken, String offerIdString) {
        this.publisherToken = publisherToken;
        this.offerIdString = offerIdString;
    }
}
