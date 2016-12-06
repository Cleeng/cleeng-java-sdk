package com.cleeng.api;

import com.cleeng.api.domain.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.List;

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

	public OfferResponse createSubscriptionOffer(SubscriptionOfferData offerData) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest( "createSubscriptionOffer", OfferParams.create( this.publisherToken, offerData) )
		);
		return gson.fromJson( response, OfferResponse.class );
	}

	public void createSubscriptionOfferAsync( List<AsyncRequest> requests ) throws IOException, InterruptedException {
		for ( AsyncRequest request : requests ) {
			request.endpoint = this.platformUrl;
			request.data = new OfferRequest( "createSubscriptionOffer", OfferParams.create( this.publisherToken, (SubscriptionOfferData) request.input ) );
		}
		this.client.invokeAsync( requests );
	}

	public SingleOfferResponse createSingleOffer(SingleOfferData offerData) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest( "createSingleOffer", OfferParams.create( this.publisherToken, offerData ) )
		);
		return gson.fromJson( response, SingleOfferResponse.class );
	}

	public void createSingleOfferAsync( List<AsyncRequest> requests ) throws IOException, InterruptedException {
		for ( AsyncRequest request : requests ) {
			request.endpoint = this.platformUrl;
			request.data = new OfferRequest( "createSingleOffer", OfferParams.create( this.publisherToken, (SingleOfferData) request.input ) );
		}
		this.client.invokeAsync( requests );
	}

	public EventOfferResponse createEventOffer(EventOfferData offerData) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest( "createEventOffer", OfferParams.create( this.publisherToken, offerData ) )
		);
		return gson.fromJson( response, EventOfferResponse.class );
	}

	public void createEventOfferAsync( List<AsyncRequest> requests ) throws IOException, InterruptedException {
		for ( AsyncRequest request : requests ) {
			request.endpoint = this.platformUrl;
			request.data = new OfferRequest( "createEventOffer", OfferParams.create( this.publisherToken, (EventOfferData) request.input ) );
		}
		this.client.invokeAsync( requests );
	}

	public RentalOfferResponse createRentalOffer( RentalOfferData offerData ) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new RentalOfferRequest( "createRentalOffer", RentalOfferParams.create( this.publisherToken, offerData ) )
		);
		return gson.fromJson( response, RentalOfferResponse.class );
	}

	public void createRentalOfferAsync( List<AsyncRequest> requests ) throws IOException, InterruptedException {
		for ( AsyncRequest request : requests ) {
			request.endpoint = this.platformUrl;
			request.data = new RentalOfferRequest( "createRentalOffer", RentalOfferParams.create( this.publisherToken, (RentalOfferData) request.input ) );
		}
		this.client.invokeAsync( requests );
	}

	public PassOfferResponse createPassOffer(PassOfferData offerData) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest( "createPassOffer", OfferParams.create( this.publisherToken, offerData ) )
		);
		return gson.fromJson( response, PassOfferResponse.class );
	}

	public void createPassOfferAsync( List<AsyncRequest> requests ) throws IOException, InterruptedException {
		for ( AsyncRequest request : requests ) {
			request.endpoint = this.platformUrl;
			request.data = new OfferRequest( "createPassOffer", OfferParams.create( this.publisherToken, (PassOfferData) request.input ) );
		}
		this.client.invokeAsync( requests );
	}

	public ListSubscriptionOffersResponse listSubscriptionOffers(Criteria criteria, int offset, int limit) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new ListRequest( "listSubscriptionOffers", ListParams.create( this.publisherToken, criteria, offset, limit ) )
		);
		return gson.fromJson( response, ListSubscriptionOffersResponse.class );
	}

	public void listSubscriptionOffersAsync( List<AsyncRequest> requests ) throws IOException, InterruptedException {
		for ( AsyncRequest request : requests ) {
			request.endpoint = this.platformUrl;
			request.data = new ListRequest( "listSubscriptionOffers", ListParams.create( this.publisherToken, (Criteria) ((AsyncListRequest) request).input, ((AsyncListRequest) request).offset, ((AsyncListRequest) request).limit ) );
		}
		this.client.invokeAsync( requests );
	}

	public ListSingleOffersResponse listSingleOffers(Criteria criteria, int offset, int limit) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new ListRequest( "listSingleOffers", ListParams.create( this.publisherToken, criteria, offset, limit ) )
		);
		return gson.fromJson( response, ListSingleOffersResponse.class );
	}

	public void listSingleOffersAsync( List<AsyncRequest> requests ) throws IOException, InterruptedException {
		for ( AsyncRequest request : requests ) {
			request.endpoint = this.platformUrl;
			request.data = new ListRequest( "listSingleOffers", ListParams.create( this.publisherToken, (Criteria) ((AsyncListRequest) request).input, ((AsyncListRequest) request).offset, ((AsyncListRequest) request).limit ) );
		}
		this.client.invokeAsync( requests );
	}

	public ListPassOffersResponse listPassOffers(Criteria criteria, int offset, int limit) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new ListRequest( "listPassOffers", ListParams.create( this.publisherToken, criteria, offset, limit ) )
		);
		return gson.fromJson( response, ListPassOffersResponse.class );
	}

	public void listPassOffersAsync( List<AsyncRequest> requests ) throws IOException, InterruptedException {
		for ( AsyncRequest request : requests ) {
			request.endpoint = this.platformUrl;
			request.data = new ListRequest( "listPassOffers", ListParams.create( this.publisherToken, (Criteria) ((AsyncListRequest) request).input, ((AsyncListRequest) request).offset, ((AsyncListRequest) request).limit ) );
		}
		this.client.invokeAsync( requests );
	}

	public PrepareRemoteAuthResponse prepareRemoteAuth(CustomerData customerData, FlowDescription flowDescription) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new PrepareRemoteAuthRequest( "prepareRemoteAuth", PrepareRemoteAuthParams.create( this.publisherToken, customerData, flowDescription ) )
		);
		return gson.fromJson( response, PrepareRemoteAuthResponse.class );
	}

	public GenerateCustomerTokenResponse generateCustomerToken(String customerEmail) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new GenerateCustomerTokenRequest( "generateCustomerToken", GenerateCustomerTokenParams.create( this.publisherToken, customerEmail ) )
		);
		return gson.fromJson( response, GenerateCustomerTokenResponse.class );
	}

	public void generateCustomerTokenAsync( List<AsyncRequest> requests ) throws IOException, InterruptedException {
		for ( AsyncRequest request : requests ) {
			request.endpoint = this.platformUrl;
			request.data = new GenerateCustomerTokenRequest( "generateCustomerToken", GenerateCustomerTokenParams.create( this.publisherToken, ( (AsyncTokenRequest) request).customerEmail ) );
		}
		this.client.invokeAsync( requests );
	}

	public GetAccessStatusResponse getAccessStatus(String customerToken, String offerId, String ipAddress) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new GetAccessStatusRequest( "getAccessStatus", new GetAccessStatusParams( customerToken, offerId, ipAddress ) )
		);
		return gson.fromJson( response, GetAccessStatusResponse.class );
	}

	public GetAccessibleTagsResponse getAccessibleTags(String publisherToken, String customerToken) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new GetAccessibleTagsRequest( "getAccessibleTags", new GetAccessibleTagsParams( publisherToken, customerToken ) )
		);
		return gson.fromJson( response, GetAccessibleTagsResponse.class );
	}
}
