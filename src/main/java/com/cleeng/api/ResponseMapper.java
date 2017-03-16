package com.cleeng.api;

import java.util.HashMap;
import java.util.Map;

public class ResponseMapper {

    private Map<String, String> map;

    public ResponseMapper() {

        this.map = new HashMap<String, String>();
        this.build();
    }

    public String map(String methodName) {
        return this.map.get(methodName);
    }

    private void build() {
        String domainPath = "com.cleeng.api.domain.";
        this.map.put("createSubscriptionOffer", domainPath + "OfferResponse");
        this.map.put("listSubscriptionOffers", domainPath + "ListSubscriptionOffersResponse");
        this.map.put("updateSubscriptionOffer", domainPath + "OfferResponse");
        this.map.put("createSingleOffer", domainPath + "SingleOfferResponse");
        this.map.put("updateSingleOffer", domainPath + "SingleOfferResponse");
        this.map.put("createEventOffer", domainPath + "EventOfferResponse");
        this.map.put("updateEventOffer", domainPath + "EventOfferResponse");
        this.map.put("createRentalOffer", domainPath + "RentalOfferResponse");
        this.map.put("updateRentalOffer", domainPath + "RentalOfferResponse");
        this.map.put("createPassOffer", domainPath + "PassOfferResponse");
        this.map.put("updatePassOffer", domainPath + "OfferResponse");
        this.map.put("listSubscriptionOffers", domainPath + "ListSubscriptionOffersResponse");
        this.map.put("listSingleOffers", domainPath + "ListSingleOffersResponse");
        this.map.put("listVodOffers", domainPath + "ListVodOffersResponse");
        this.map.put("listPassOffers", domainPath + "ListPassOffersResponse");
        this.map.put("prepareRemoteAuth", domainPath + "PrepareRemoteAuthResponse");
        this.map.put("generateCustomerToken", domainPath + "TokenResponse");
        this.map.put("requestPasswordReset", domainPath + "BooleanResponse");
        this.map.put("updateCustomerPassword", domainPath + "BooleanResponse");
        this.map.put("generateCustomerTokenFromFacebook", domainPath + "TokenResponse");
        this.map.put("generateCustomerTokenFromPassword", domainPath + "TokenResponse");
        this.map.put("getAccessStatus", domainPath + "GetAccessStatusResponse");
        this.map.put("getAccessibleTags", domainPath + "GetAccessibleTagsResponse");
        this.map.put("getCustomer", domainPath + "GetCustomerResponse");
        this.map.put("createVodOffer", domainPath + "VodOfferResponse");
        this.map.put("getVodOffer", domainPath + "VodOfferResponse");
        this.map.put("updateVodOffer", domainPath + "VodOfferResponse");
        this.map.put("generateCheckoutUrl", domainPath + "UrlResponse");
        this.map.put("registerCustomer", domainPath + "TokenResponse");
        this.map.put("generateMyAccountUrl", domainPath + "UrlResponse");
        this.map.put("listOfferIdsByVideoId", domainPath + "ListOfferIdsByVideoIdResponse");
        this.map.put("getAccessStatusForDevice", domainPath + "GetAccessStatusForDeviceResponse");
    }
}
