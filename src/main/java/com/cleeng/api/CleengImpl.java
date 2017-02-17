package com.cleeng.api;

import com.cleeng.api.domain.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsonrpc.JSONRPCRequest;

import java.io.IOException;
import java.util.ArrayList;
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

	public void setNonBlockingMode() {
		this.client.useNonBlockingMode = true;
	}

	public CleengImpl(String platformUrl, String publisherToken) {
		this(platformUrl);
		this.publisherToken = publisherToken;
	}

	public OfferResponse createSubscriptionOffer(SubscriptionOfferData offerData) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest("createSubscriptionOffer", OfferParams.create(this.publisherToken, offerData))
		);
		return gson.fromJson(response, OfferResponse.class);
	}

	public void createSubscriptionOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new OfferRequest("createSubscriptionOffer", OfferParams.create(this.publisherToken, (SubscriptionOfferData) request.input));
		}
		this.client.invokeAsync(requests);
	}

	public OfferResponse updateSubscriptionOffer(SubscriptionOfferData offerData, String offerId) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest("updateSubscriptionOffer", new UpdateOfferParams(this.publisherToken, offerData, offerId))
		);
		return gson.fromJson(response, OfferResponse.class);
	}

	public void updateSubscriptionOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new OfferRequest("updateSubscriptionOffer", new UpdateOfferParams(this.publisherToken,
					((AsyncUpdateOfferRequest) request).offerData,
					((AsyncUpdateOfferRequest) request).offerId));
		}
		this.client.invokeAsync(requests);
	}

	public SingleOfferResponse createSingleOffer(SingleOfferData offerData) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest("createSingleOffer", OfferParams.create(this.publisherToken, offerData))
		);
		return gson.fromJson(response, SingleOfferResponse.class);
	}

	public void createSingleOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new OfferRequest("createSingleOffer", OfferParams.create(this.publisherToken, (SingleOfferData) request.input));
		}
		this.client.invokeAsync(requests);
	}

	public SingleOfferResponse updateSingleOffer(String offerId, SingleOfferData offerData) throws IOException {
		final String response = this.client.invoke(
			this.platformUrl,
			new OfferRequest("updateSingleOffer", new UpdateOfferParams(this.publisherToken, offerData, offerId))
		);
		return gson.fromJson(response, SingleOfferResponse.class);
	}

	public void updateSingleOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new OfferRequest("updateSingleOffer", new UpdateOfferParams(this.publisherToken,
					((AsyncUpdateOfferRequest) request).offerData,
					((AsyncUpdateOfferRequest) request).offerId));
		}
		this.client.invokeAsync(requests);
	}

	public EventOfferResponse createEventOffer(EventOfferData offerData) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest("createEventOffer", OfferParams.create(this.publisherToken, offerData))
		);
		return gson.fromJson(response, EventOfferResponse.class);
	}

	public void createEventOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new OfferRequest("createEventOffer", OfferParams.create(this.publisherToken, (EventOfferData) request.input));
		}
		this.client.invokeAsync(requests);
	}

	public EventOfferResponse updateEventOffer(EventOfferData offerData, String offerId) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest("updateEventOffer", new UpdateOfferParams(this.publisherToken, offerData, offerId))
		);
		return gson.fromJson(response, EventOfferResponse.class);
	}

	public void updateEventOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new OfferRequest("updateEventOffer", new UpdateOfferParams(this.publisherToken,
					((AsyncUpdateOfferRequest) request).offerData,
					((AsyncUpdateOfferRequest) request).offerId));
		}
		this.client.invokeAsync(requests);
	}

	public RentalOfferResponse createRentalOffer(RentalOfferData offerData) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new RentalOfferRequest("createRentalOffer", RentalOfferParams.create(this.publisherToken, offerData))
		);
		return gson.fromJson(response, RentalOfferResponse.class);
	}

	public void createRentalOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new RentalOfferRequest("createRentalOffer", RentalOfferParams.create(this.publisherToken, (RentalOfferData) request.input));
		}
		this.client.invokeAsync(requests);
	}

	public RentalOfferResponse updateRentalOffer(RentalOfferData offerData, String offerId) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest("updateRentalOffer", new UpdateOfferParams(this.publisherToken, offerData, offerId))
		);
		return gson.fromJson(response, RentalOfferResponse.class);
	}

	public void updateRentalOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new OfferRequest("updateRentalOffer", new UpdateOfferParams(this.publisherToken,
					((AsyncUpdateOfferRequest) request).offerData,
					((AsyncUpdateOfferRequest) request).offerId));
		}
		this.client.invokeAsync(requests);
	}

	public PassOfferResponse createPassOffer(PassOfferData offerData) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest("createPassOffer", OfferParams.create(this.publisherToken, offerData))
		);
		return gson.fromJson(response, PassOfferResponse.class);
	}

	public void createPassOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new OfferRequest("createPassOffer", OfferParams.create(this.publisherToken, (PassOfferData) request.input));
		}
		this.client.invokeAsync(requests);
	}

	public OfferResponse updatePassOffer(PassOfferData offerData, String offerId) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new OfferRequest("updatePassOffer", new UpdateOfferParams(this.publisherToken, offerData, offerId))
		);
		return gson.fromJson(response, OfferResponse.class);
	}

	public void updatePassOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new OfferRequest("updatePassOffer", new UpdateOfferParams(this.publisherToken,
					((AsyncUpdateOfferRequest) request).offerData,
					((AsyncUpdateOfferRequest) request).offerId));
		}
		this.client.invokeAsync(requests);
	}

	public ListSubscriptionOffersResponse listSubscriptionOffers(Criteria criteria, int offset, int limit) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new ListRequest("listSubscriptionOffers", ListParams.create(this.publisherToken, criteria, offset, limit))
		);
		return gson.fromJson(response, ListSubscriptionOffersResponse.class);
	}

	public void listSubscriptionOffersAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new ListRequest("listSubscriptionOffers", ListParams.create(this.publisherToken,
					(Criteria) ((AsyncListRequest) request).input,
					((AsyncListRequest) request).offset, ((AsyncListRequest) request).limit));
		}
		this.client.invokeAsync(requests);
	}

	public ListSingleOffersResponse listSingleOffers(Criteria criteria, int offset, int limit) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new ListRequest("listSingleOffers", ListParams.create(this.publisherToken, criteria, offset, limit))
		);
		return gson.fromJson(response, ListSingleOffersResponse.class);
	}

	public void listSingleOffersAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new ListRequest("listSingleOffers", ListParams.create(this.publisherToken,
					(Criteria) ((AsyncListRequest) request).input,
					((AsyncListRequest) request).offset,
					((AsyncListRequest) request).limit));
		}
		this.client.invokeAsync(requests);
	}

	public ListPassOffersResponse listPassOffers(Criteria criteria, int offset, int limit) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new ListRequest("listPassOffers", ListParams.create( this.publisherToken, criteria, offset, limit))
		);
		return gson.fromJson(response, ListPassOffersResponse.class);
	}

	public void listPassOffersAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new ListRequest("listPassOffers", ListParams.create(this.publisherToken,
					(Criteria) ((AsyncListRequest) request).input,
					((AsyncListRequest) request).offset, ((AsyncListRequest) request).limit));
		}
		this.client.invokeAsync(requests);
	}

	public PrepareRemoteAuthResponse prepareRemoteAuth(CustomerData customerData, FlowDescription flowDescription) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new PrepareRemoteAuthRequest("prepareRemoteAuth", PrepareRemoteAuthParams.create(this.publisherToken, customerData, flowDescription))
		);
		return gson.fromJson(response, PrepareRemoteAuthResponse.class);
	}

	public void prepareRemoteAuthAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new PrepareRemoteAuthRequest("prepareRemoteAuth", PrepareRemoteAuthParams.create(this.publisherToken,
					((AsyncPrepareRemoteAuthRequest) request).customerData,
					((AsyncPrepareRemoteAuthRequest) request).flowDescription));
		}
		this.client.invokeAsync(requests);
	}

	public TokenResponse generateCustomerToken(String customerEmail) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new JSONRPCRequest("generateCustomerToken", GenerateCustomerTokenParams.create(this.publisherToken, customerEmail))
		);
		return gson.fromJson(response, TokenResponse.class);
	}

	public void generateCustomerTokenAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new JSONRPCRequest("generateCustomerToken", GenerateCustomerTokenParams.create(this.publisherToken, ((AsyncTokenRequest) request).input));
		}
		this.client.invokeAsync(requests);
	}

	public BooleanResponse requestPasswordReset(String customerEmail) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new JSONRPCRequest("requestPasswordReset", GenerateCustomerTokenParams.create(this.publisherToken, customerEmail))
		);
		return gson.fromJson(response, BooleanResponse.class);
	}

	public void requestPasswordResetAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new JSONRPCRequest("requestPasswordReset", GenerateCustomerTokenParams.create(this.publisherToken, ((AsyncTokenRequest) request).input));
		}
		this.client.invokeAsync(requests);
	}

	public BooleanResponse updateCustomerPassword(String customerEmail, String resetPasswordToken, String newPassword) throws IOException {
		final String response = this.client.invoke(
			this.platformUrl,
			new JSONRPCRequest("updateCustomerPassword", new ResetPasswordParams(this.publisherToken, customerEmail, resetPasswordToken, newPassword))
		);
		return gson.fromJson(response, BooleanResponse.class);
	}

	public void updateCustomerPasswordAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new JSONRPCRequest("updateCustomerPassword", new ResetPasswordParams(this.publisherToken,
					((ResetPasswordParams) ((AsyncRequest) request).input).customerEmail,
					((ResetPasswordParams) ((AsyncRequest) request).input).resetPasswordToken,
					((ResetPasswordParams) ((AsyncRequest) request).input).newPassword));
		}
		this.client.invokeAsync(requests);
	}

	public TokenResponse generateCustomerTokenFromFacebook(String facebookId) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new JSONRPCRequest("generateCustomerTokenFromFacebook", GenerateCustomerTokenFromFacebookParams.create(this.publisherToken, facebookId))
		);
		return gson.fromJson(response, TokenResponse.class);
	}

	public void generateCustomerTokenFromFacebookAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new JSONRPCRequest("generateCustomerTokenFromFacebook", GenerateCustomerTokenFromFacebookParams.create(this.publisherToken,
					((AsyncTokenRequest) request).input));
		}
		this.client.invokeAsync(requests);
	}

	public TokenResponse generateCustomerTokenFromPassword(String password, String customerEmail) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new JSONRPCRequest("generateCustomerTokenFromPassword", GenerateCustomerTokenFromPasswordParams.create(this.publisherToken, password, customerEmail))
		);
		return gson.fromJson(response, TokenResponse.class);
	}

	public void generateCustomerTokenFromPasswordAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new JSONRPCRequest("generateCustomerTokenFromPassword", GenerateCustomerTokenFromPasswordParams.create(this.publisherToken,
					((AsyncGenerateCustomerTokenFromPasswordRequest) request).password, ((AsyncGenerateCustomerTokenFromPasswordRequest) request).customerEmail));
		}
		this.client.invokeAsync(requests);
	}

	public GetAccessStatusResponse getAccessStatus(String customerToken, String offerId, String ipAddress) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new GetAccessStatusRequest("getAccessStatus", new GetAccessStatusParams(customerToken, offerId, ipAddress))
		);
		return gson.fromJson(response, GetAccessStatusResponse.class);
	}

	public void getAccessStatusAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new GetAccessStatusRequest("getAccessStatus", new GetAccessStatusParams(((AsyncGetAccessStatusRequest) request).customerToken,
					((AsyncGetAccessStatusRequest) request).offerId, ((AsyncGetAccessStatusRequest) request).ipAddress));
		}
		this.client.invokeAsync(requests);
	}

	public GetAccessibleTagsResponse getAccessibleTags(String publisherToken, String customerToken) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new GetAccessibleTagsRequest("getAccessibleTags", new GetAccessibleTagsParams(publisherToken, customerToken))
		);
		return gson.fromJson(response, GetAccessibleTagsResponse.class);
	}

	public void getAccessibleTagsAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new GetAccessibleTagsRequest("getAccessibleTags", new GetAccessibleTagsParams(((AsyncGetAccessibleTagsRequest) request).publisherToken,
					((AsyncGetAccessibleTagsRequest) request).customerToken));
		}
		this.client.invokeAsync(requests);
	}

	public GetCustomerResponse getCustomer(String customerToken) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new GetCustomerRequest("getCustomer", new GetCustomerParams(customerToken))
		);
		return gson.fromJson(response, GetCustomerResponse.class);
	}

	public void getCustomerAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new GetCustomerRequest("getCustomer", new GetCustomerParams((String) request.input));
		}
		this.client.invokeAsync(requests);
	}

	public VodOfferResponse createVodOffer(VodOfferData offerData) throws IOException {
		final String response = this.client.invoke(
			this.platformUrl,
			new VodOfferRequest("createVodOffer", new CreateVodOfferParams(publisherToken, offerData))
		);
		return gson.fromJson(response, VodOfferResponse.class);
	}

	public void createVodOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new VodOfferRequest("createVodOffer",
					new CreateVodOfferParams(((AsyncCreateVodOfferRequest) request).publisherToken,
					((AsyncCreateVodOfferRequest) request).offerData));
		}
		this.client.invokeAsync(requests);
	}

	public VodOfferResponse getVodOffer(String offerId) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new GetVodOfferRequest("getVodOffer", new GetVodOfferParams(publisherToken, offerId))
		);
		return gson.fromJson(response, VodOfferResponse.class);
	}

	public void getVodOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new GetVodOfferRequest("getVodOffer", new GetVodOfferParams(((AsyncGetVodOfferRequest) request).publisherToken,
					((AsyncGetVodOfferRequest) request).offerId));
		}
		this.client.invokeAsync(requests);
	}

	public VodOfferResponse updateVodOffer(String offerId, VodOfferData offerData) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new VodOfferRequest("updateVodOffer", new UpdateVodOfferParams(publisherToken, offerData, offerId))
		);
		return gson.fromJson(response, VodOfferResponse.class);
	}

	public void updateVodOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new VodOfferRequest("updateVodOffer", new UpdateVodOfferParams(((AsyncUpdateVodOfferRequest) request).publisherToken,
					((AsyncUpdateVodOfferRequest) request).offerData, ((AsyncUpdateVodOfferRequest) request).offerIdString));
		}
		this.client.invokeAsync(requests);
	}

	public UrlResponse generateCheckoutUrl(String customerEmail, FlowDescription flowDescription) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new GenerateCheckoutUrlRequest("generateCheckoutUrl", new GenerateCheckoutUrlParams(publisherToken, customerEmail, flowDescription))
		);
		return gson.fromJson(response, UrlResponse.class);
	}

	public void generateCheckoutUrlAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new GenerateCheckoutUrlRequest("generateCheckoutUrl", new GenerateCheckoutUrlParams(((AsyncGenerateCheckoutUrlRequest) request).publisherToken,
					((AsyncGenerateCheckoutUrlRequest) request).customerEmail, ((AsyncGenerateCheckoutUrlRequest) request).flowDescription));
		}
		this.client.invokeAsync(requests);
	}

	public TokenResponse registerCustomer(CustomerData data) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new JSONRPCRequest("registerCustomer", new RegisterCustomerParams(this.publisherToken, data))
		);
		return gson.fromJson(response, TokenResponse.class);
	}

	public void registerCustomerAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new JSONRPCRequest("registerCustomer", new RegisterCustomerParams(this.publisherToken,
					(CustomerData) ((AsyncRequest) request).input));
		}
		this.client.invokeAsync(requests);
	}

	public UrlResponse generateMyAccountUrl(String customerEmail, List<String> modules) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new JSONRPCRequest("generateMyAccountUrl", new GenerateMyAccountUrlParams(this.publisherToken, customerEmail, modules))
		);
		return gson.fromJson(response, UrlResponse.class);
	}

	public void generateMyAccountUrlAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new JSONRPCRequest("generateMyAccountUrl", new GenerateMyAccountUrlParams(this.publisherToken,
					((GenerateMyAccountUrlParams) ((AsyncRequest) request).input).customerEmail,
					((GenerateMyAccountUrlParams) ((AsyncRequest) request).input).modules));
		}
		this.client.invokeAsync(requests);
	}
}
