package com.cleeng.api;

import com.cleeng.api.domain.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class CleengImpl implements Cleeng {

	private String publisherToken;
	private String platformUrl;
	private Gson gson;
	private HttpClient client;

	public CleengImpl(final String platformUrl) {
		this.gson = new GsonBuilder().create();
		this.client = new HttpClient();
		this.platformUrl = platformUrl;
	}

	public CleengImpl(String platformUrl, String publisherToken) {
		this(platformUrl);
		this.publisherToken = publisherToken;
	}

	public OfferResponse createSubscriptionOffer(OfferData offerData) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest( "createSubscriptionOffer", OfferParams.create( this.publisherToken, offerData) )
		);
		return gson.fromJson( response, OfferResponse.class );
	}

	public SingleOfferResponse createSingleOffer(SingleOfferData offerData) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest( "createSingleOffer", OfferParams.create( this.publisherToken, offerData ) )
		);
		return gson.fromJson( response, SingleOfferResponse.class );
	}

	public EventOfferResponse createEventOffer(EventOfferData offerData) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest( "createEventOffer", OfferParams.create( this.publisherToken, offerData ) )
		);
		return gson.fromJson( response, EventOfferResponse.class );
	}

	public RentalOfferResponse createRentalOffer(RentalOfferData offerData) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest( "createRentalOffer", OfferParams.create( this.publisherToken, offerData ) )
		);
		return gson.fromJson( response, RentalOfferResponse.class );
	}

	public PassOfferResponse createPassOffer(PassOfferData offerData) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest( "createPassOffer", OfferParams.create( this.publisherToken, offerData ) )
		);
		return gson.fromJson( response, PassOfferResponse.class );
	}

	public ListSubscriptionOffersResponse listSubscriptionOffers(Criteria criteria, int offset, int limit) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new ListRequest( "listSubscriptionOffers", ListParams.create( this.publisherToken, criteria, offset, limit ) )
		);
		return gson.fromJson( response, ListSubscriptionOffersResponse.class );
	}

	public ListSingleOffersResponse listSingleOffers(Criteria criteria, int offset, int limit) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new ListRequest( "listSingleOffers", ListParams.create( this.publisherToken, criteria, offset, limit ) )
		);
		return gson.fromJson( response, ListSingleOffersResponse.class );
	}
}
