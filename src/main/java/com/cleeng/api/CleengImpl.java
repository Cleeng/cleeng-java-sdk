package com.cleeng.api;

import com.cleeng.api.domain.*;
import com.cleeng.api.domain.async.*;
import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsonrpc.JSONRPCRequest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;

public class CleengImpl implements Cleeng {

	private static final Logger logger = LogManager.getLogger(CleengImpl.class);

	private String publisherToken;
	private String platformUrl;
	private Gson gson;
	private HttpClient client;
	private Config config;

	public CleengImpl(String platformUrl,
					  String platformUrlSandbox,
					  boolean useSandbox,
					  String publisherToken,
					  String propertiesPath,
					  int socketTimeout,
					  int connectTimeout,
					  int requestTimeout,
					  int retryCount,
					  int useNonBlockingMode) {
		this.config = new Config();
		if (propertiesPath != null) {
			this.initProps(propertiesPath);
		}
		if (socketTimeout > 0) {
			this.config.socketTimeout = socketTimeout;
		}
		if (connectTimeout > 0) {
			this.config.connectTimeout = connectTimeout;
		}
		if (requestTimeout > 0) {
			this.config.requestTimeout = requestTimeout;
		}
		if (retryCount > 0) {
			this.config.retryCount = retryCount;
		}
		if (platformUrl != null) {
			this.config.platformUrl = platformUrl;
		}
		if (platformUrlSandbox != null) {
			this.config.platformUrlSandbox = platformUrlSandbox;
		}
		this.config.useSandbox = useSandbox;
		if (useNonBlockingMode != -1) {
			if (useNonBlockingMode == 1) {
				this.config.useNonBlockingMode = true;
			} else if (useNonBlockingMode == 0) {
				this.config.useNonBlockingMode = false;
			}
		}
		this.gson = new GsonBuilder().create();
		this.client = new HttpClient();
		this.client.config = this.config;
		this.platformUrl = (useSandbox == true) ? this.config.platformUrlSandbox : this.config.platformUrl;
		this.publisherToken = publisherToken;
	}

	public HttpClient getClient() {
		return this.client;
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
			request.data = new ListRequest("listVodOffers", ListParams.create(this.publisherToken,
					(Criteria) ((AsyncListRequest) request).input,
					((AsyncListRequest) request).offset,
					((AsyncListRequest) request).limit));
		}
		this.client.invokeAsync(requests);
	}

	public ListVodOffersResponse listVodOffers(Criteria criteria, int offset, int limit) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new ListRequest("listVodOffers", ListParams.create(this.publisherToken, criteria, offset, limit))
		);
		return gson.fromJson(response, ListVodOffersResponse.class);
	}

	public void listVodOffersAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new ListRequest("listVodOffers", ListParams.create(this.publisherToken,
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

	public BooleanResponse updateCustomerEmail(String customerEmail, String newEmail) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new JSONRPCRequest("updateCustomerEmail", new UpdateCustomerEmailParams(this.publisherToken, customerEmail, newEmail))
		);
		return gson.fromJson(response, BooleanResponse.class);
	}

	public void updateCustomerEmailAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new JSONRPCRequest("updateCustomerEmail", new UpdateCustomerEmailParams(this.publisherToken,
				((UpdateCustomerEmailParams) ((AsyncRequest) request).input).customerEmail,
				((UpdateCustomerEmailParams) ((AsyncRequest) request).input).newEmail));
		}
		this.client.invokeAsync(requests);
	}

	public BooleanResponse isTrialAllowed(String customerEmail, String offerId) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new JSONRPCRequest("isTrialAllowed", new IsTrialAllowedParams(this.publisherToken, customerEmail, offerId))
		);
		return gson.fromJson(response, BooleanResponse.class);
	}

	public void isTrialAllowedAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new JSONRPCRequest("isTrialAllowed", new IsTrialAllowedParams(this.publisherToken,
				((IsTrialAllowedParams) ((AsyncRequest) request).input).customerEmail,
				((IsTrialAllowedParams) ((AsyncRequest) request).input).offerId));
		}
		this.client.invokeAsync(requests);
	}

	public UpdateCustomerSubscriptionResponse updateCustomerSubscription(String offerId, String customerEmail, UpdateCustomerSubscriptionOfferData offerData) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new JSONRPCRequest("updateCustomerSubscription", new UpdateCustomerSubscriptionParams(this.publisherToken, customerEmail, offerId, offerData))
		);
		return gson.fromJson(response, UpdateCustomerSubscriptionResponse.class);
	}

	public void updateCustomerSubscriptionAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new JSONRPCRequest("updateCustomerSubscription", new UpdateCustomerSubscriptionParams(this.publisherToken,
				((UpdateCustomerSubscriptionParams) ((AsyncRequest) request).input).customerEmail,
				((UpdateCustomerSubscriptionParams) ((AsyncRequest) request).input).offerId,
				((UpdateCustomerSubscriptionParams) ((AsyncRequest) request).input).subscriptionData));
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

	public PaymentDetailsResponse listPaymentDetails(String userEmail) throws IOException {
		final String response = this.client.invoke(
			this.platformUrl,
			new JSONRPCRequest("listPaymentDetails", new PaymentDetailsParams(this.publisherToken, userEmail))
		);
		return gson.fromJson(response, PaymentDetailsResponse.class);
	}

	public void listPaymentDetailsAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new JSONRPCRequest("listPaymentDetails", new PaymentDetailsParams(this.publisherToken,
				((PaymentDetailsParams) ((AsyncRequest) request).input).userEmail));
		}
		this.client.invokeAsync(requests);
	}

	public BooleanResponse deletePaymentDetails(String paymentDetailsId) throws IOException {
		final String response = this.client.invoke(
			this.platformUrl,
			new JSONRPCRequest("deletePaymentDetails", new DeletePaymentDetailsParams(this.publisherToken, paymentDetailsId))
		);
		return gson.fromJson(response, BooleanResponse.class);
	}

	public void deletePaymentDetailsAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new JSONRPCRequest("deletePaymentDetails", new DeletePaymentDetailsParams(this.publisherToken,
				((DeletePaymentDetailsParams) ((AsyncRequest) request).input).paymentDetailsId));
		}
		this.client.invokeAsync(requests);
	}

	public ListOfferIdsByVideoIdResponse listOfferIdsByVideoId(String videoId) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new JSONRPCRequest("listOfferIdsByVideoId", new VideoIdParams(this.publisherToken, videoId))
		);
		return gson.fromJson(response, ListOfferIdsByVideoIdResponse.class);
	}

	public void listOfferIdsByVideoIdAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new JSONRPCRequest("listOfferIdsByVideoId", new VideoIdParams(this.publisherToken,
					((VideoIdParams) ((AsyncRequest) request).input).videoId));
		}
		this.client.invokeAsync(requests);
	}

	public GetAccessStatusForDeviceResponse getAccessStatusForDevice(String customerToken, String offerId, String deviceId, String deviceType) throws IOException {
		final String response = this.client.invoke(
				this.platformUrl,
				new JSONRPCRequest("getAccessStatusForDevice", new GetAccessStatusForDeviceParams(customerToken, offerId, deviceId, deviceType))
		);
		return gson.fromJson(response, GetAccessStatusForDeviceResponse.class);
	}

	public void getAccessStatusForDeviceAsync(List<AsyncRequest> requests) throws IOException, InterruptedException {
		for (AsyncRequest request : requests) {
			request.endpoint = this.platformUrl;
			request.data = new JSONRPCRequest("getAccessStatusForDevice", request.input);
		}
		this.client.invokeAsync(requests);
	}

	public void invokeBatchAsync(BatchAsyncRequest batch) throws IOException, InterruptedException {
		this.client.invokeBatchAsync(batch, this.platformUrl);
	}

	public BatchResponse invokeBatch(BatchRequest batch) throws IOException {
		final ResponseMapper mapper = new ResponseMapper();
		final String response = this.client.invokeBatch(batch, this.platformUrl);
		final BatchResponse batchResponse = new BatchResponse();
		final JsonParser parser = new JsonParser();
		final JsonArray o = parser.parse(response).getAsJsonArray();
		for (int i = 0; i < o.size(); i++) {
			JsonElement element = o.get(i);
			for (int j = 0; j < batch.getRequests().size(); j++) {
				JSONRPCRequest r = (JSONRPCRequest) batch.getRequests().get(j);
				if (element.isJsonObject()) {
					JsonObject res = element.getAsJsonObject();
					if (res.get("id").getAsString().equals(r.id)) {
						String responseTypeName = mapper.map(r.method);
						if (responseTypeName != null) {
							try {
								logger.info("Processing " + responseTypeName);
								Serializable payload = (Serializable) this.gson.fromJson(res, Class.forName(responseTypeName));
								batchResponse.responses.add(payload);
							} catch (ClassNotFoundException e) {
								logger.error("Class not found " + e);
							}
						} else {
							logger.warn("Mapper did not contain a response type for " + r.getClass().getTypeName());
						}
					}
				}
			}
		}
		return batchResponse;
	}

	private void initProps(String propertiesPath) {
		final Properties properties = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(propertiesPath);
			properties.load(input);
			try {
				this.config.socketTimeout = Integer.parseInt(properties.getProperty("socketTimeout"));
			} catch (NumberFormatException e) {

			}
			try {
				this.config.connectTimeout = Integer.parseInt(properties.getProperty("connectTimeout"));
			} catch (NumberFormatException e) {

			}
			try {
				this.config.requestTimeout = Integer.parseInt(properties.getProperty("requestTimeout"));
			} catch (NumberFormatException e) {

			}
			try {
				this.config.retryCount = Integer.parseInt(properties.getProperty("retryCount"));
			} catch (NumberFormatException e) {

			}
			this.config.useNonBlockingMode = Boolean.parseBoolean(properties.getProperty("useNonBlockingMode"));
			this.config.platformUrl = properties.getProperty("platformUrl");
			this.config.platformUrlSandbox = properties.getProperty("platformUrlSandbox");
		} catch (IOException e) {
			logger.error("Config file not found or invalid.");
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {

				}
			}
		}
	}
}
