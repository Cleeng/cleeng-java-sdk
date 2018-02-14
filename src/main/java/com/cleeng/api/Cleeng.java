package com.cleeng.api;

import com.cleeng.api.domain.*;
import com.cleeng.api.domain.async.AsyncRequest;

import java.io.IOException;
import java.util.List;

/**
 * Cleeng API. Set of methods to interact with Cleeng platform.
 * 
 */
public interface Cleeng {

	HttpClient getClient();

	/**
	 * Creates a subscription offer.<br/>
	 * <br/>
	 *
	 * @param offerData domain object representing offer data
	 * @return
	 */
	OfferResponse createSubscriptionOffer(SubscriptionOfferData offerData) throws IOException;

	/**
	 * Creates subscription offers (async)
	 * <br/>
	 *
	 * @param requests
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void createSubscriptionOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Updates a subscription offer.<br/>
	 * <br/>
	 *
	 * @param offerData domain object representing offer data
	 * @param offerId offer id
	 * @return
	 */
	OfferResponse updateSubscriptionOffer(SubscriptionOfferData offerData, String offerId) throws IOException;

	/**
	 * Updates subscription offers (async)
	 * <br/>
	 *
	 * @param requests
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void updateSubscriptionOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Creates a single offer.<br/>
	 * <br/>
	 *
	 * @param offerData domain object representing single offer data
	 * @return
	 */
	SingleOfferResponse createSingleOffer(SingleOfferData offerData) throws IOException;

	/**
	 * Creates single offers (async)
	 * <br/>
	 *
	 * @param requests
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void createSingleOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Updates a single offer.<br/>
	 * <br/>
	 *
	 * @param offerData domain object representing single offer data
	 * @return
	 */
	SingleOfferResponse updateSingleOffer(String offerId, SingleOfferData offerData) throws IOException;

	/**
	 * Updates single offers (async)
	 * <br/>
	 *
	 * @param requests
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void updateSingleOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Creates an event offer.<br/>
	 * <br/>
	 *
	 * @param offerData domain object representing event offer data
	 * @return
	 */
	EventOfferResponse createEventOffer(EventOfferData offerData) throws IOException;

	/**
	 * Creates an event offers (async).<br/>
	 * <br/>
	 *
	 * @param requests
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void createEventOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Updates an event offer.<br/>
	 * <br/>
	 *
	 * @param offerData domain object representing event offer data
	 * @param offerId offer Id
	 * @return
	 */
	EventOfferResponse updateEventOffer(EventOfferData offerData, String offerId) throws IOException;

	/**
	 * Updates event offers (async)
	 * <br/>
	 *
	 * @param requests
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void updateEventOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Creates a rental offer.<br/>
	 * <br/>
	 *
	 * @param offerData domain object representing rental offer data
	 * @return
	 */
	RentalOfferResponse createRentalOffer(RentalOfferData offerData) throws IOException;

	/**
	 * Creates rental offers (async).<br/>
	 * <br/>
	 *
	 * @param requests
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void createRentalOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Updates a rental offer.<br/>
	 * <br/>
	 *
	 * @param offerData domain object representing rental offer data
	 * @param offerId offer Id
	 * @return
	 */
	RentalOfferResponse updateRentalOffer(RentalOfferData offerData, String offerId) throws IOException;

	/**
	 * Updates rental offers (async)
	 * <br/>
	 *
	 * @param requests
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void updateRentalOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Creates a pass offer.<br/>
	 * <br/>
	 *
	 * @param offerData domain object representing pass offer data
	 * @return
	 */
	PassOfferResponse createPassOffer(PassOfferData offerData) throws IOException;

	/**
	 * Updates a pass offer.<br/>
	 * <br/>
	 *
	 * @param offerData domain object representing pass offer data
	 * @param offerId offer Id
	 * @return
	 */
	public OfferResponse updatePassOffer(PassOfferData offerData, String offerId) throws IOException;

	/**
	 * Updates pass offers (async)
	 * <br/>
	 *
	 * @param requests
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void updatePassOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Creates pass offers (async).<br/>
	 * <br/>
	 *
	 * @param requests
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void createPassOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Lists subscription offers.<br/>
	 * <br/>
	 *
	 * @param criteria domain object representing search criteria
	 * @param offset pagination offset
	 * @param limit pagination's items per page
	 * @return
	 */
	ListSubscriptionOffersResponse listSubscriptionOffers(Criteria criteria, int offset, int limit) throws IOException;

	/**
	 * Lists subscription offers (async).<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncListRequest objects
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void listSubscriptionOffersAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Lists single offers.<br/>
	 * <br/>
	 *
	 * @param criteria domain object representing search criteria
	 * @param offset pagination offset
	 * @param limit pagination's items per page
	 * @return
	 */
	ListSingleOffersResponse listSingleOffers(Criteria criteria, int offset, int limit) throws IOException;

	/**
	 * Lists single offers (async).<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncListRequest objects
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void listSingleOffersAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Lists vod offers.<br/>
	 * <br/>
	 *
	 * @param criteria domain object representing search criteria
	 * @param offset pagination offset
	 * @param limit pagination's items per page
	 * @return
	 */
	ListVodOffersResponse listVodOffers(Criteria criteria, int offset, int limit) throws IOException;

	/**
	 * Lists vod offers (async).<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncListRequest objects
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void listVodOffersAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Lists pass offers.<br/>
	 * <br/>
	 *
	 * @param criteria domain object representing search criteria
	 * @param offset pagination offset
	 * @param limit pagination's limit
	 * @return
	 */
	ListPassOffersResponse listPassOffers(Criteria criteria, int offset, int limit) throws IOException;

	/**
	 * Lists pass offers (async).<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncListRequest objects
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void listPassOffersAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Prepares a remote auth.<br/>
	 * <br/>
	 *
	 * @param customerData domain object representing customer's data
	 * @param flowDescription domain object representing flow description
	 * @return
	 */
	PrepareRemoteAuthResponse prepareRemoteAuth(CustomerData customerData, FlowDescription flowDescription) throws IOException;

	/**
	 * Prepares a remote auth (async).<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncPrepareRemoteAuthRequest objects
	 * @throws IOException
	 * @throws InterruptedException
	 */
	void prepareRemoteAuthAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Generates a customer token.<br/>
	 * <br/>
	 *
	 * @param customerEmail customer's email
	 * @return
	 */
	TokenResponse generateCustomerToken(String customerEmail) throws IOException;

	/**
	 * Generates a customer token (async)<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncTokenRequest objects
	 * @return
	 */
	void generateCustomerTokenAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Requests user's password reset.<br/>
	 * <br/>
	 *
	 * @param customerEmail customer's email
	 * @return
	 */
	BooleanResponse requestPasswordReset(String customerEmail) throws IOException;

	/**
	 * Requests user's password reset (async).<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncRequest objects
	 * @return
	 */
	void requestPasswordResetAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Updates user's password.<br/>
	 * <br/>
	 *
	 * @param customerEmail customer's email
	 * @param resetPasswordToken token received on email
	 * @param newPassword new password
	 * @return
	 */
	BooleanResponse updateCustomerPassword(String customerEmail, String resetPasswordToken, String newPassword) throws IOException;

	/**
	 * Updates customer password (async).<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncRequest objects
	 * @return
	 */
	public void updateCustomerPasswordAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Updates customer's subscription.<br/>
	 * <br/>
	 *
	 * @param offerId offer Id
	 * @param customerEmail customer email
	 * @param offerData offer data
	 * @return
	 */
	UpdateCustomerSubscriptionResponse updateCustomerSubscription(String offerId, String customerEmail, UpdateCustomerSubscriptionOfferData offerData) throws IOException;

	/**
	 * Updates customer's subscription (async).<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncRequest objects
	 * @return
	 */
	public void updateCustomerSubscriptionAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Updates user's email.<br/>
	 * <br/>
	 *
	 * @param customerEmail customer's email
	 * @param newEmail new email
	 * @return
	 */
	BooleanResponse updateCustomerEmail(String customerEmail, String newEmail) throws IOException;

	/**
	 * Updates customer email (async).<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncRequest objects
	 * @return
	 */
	public void updateCustomerEmailAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Generates a customer token from facebook.<br/>
	 * <br/>
	 *
	 * @param facebookId facebook login
	 * @return
	 */
	TokenResponse generateCustomerTokenFromFacebook(String facebookId) throws IOException;

	/**
	 * Generates a customer token from facebook (async)<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncTokenRequest objects
	 * @return
	 */
	void generateCustomerTokenFromFacebookAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Generates a customer token from password.<br/>
	 * <br/>
	 *
	 * @param password password
	 * @return
	 */
	TokenResponse generateCustomerTokenFromPassword(String password, String customerEmail) throws IOException;

	/**
	 * Generates a customer token from password (async)<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncTokenRequest objects
	 * @return
	 */
	void generateCustomerTokenFromPasswordAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Gets access status.<br/>
	 * <br/>
	 *
	 * @param customerToken customer token
	 * @param offerId offer Id
	 * @param ipAddress IP address
	 * @return
	 */
	GetAccessStatusResponse getAccessStatus(String customerToken, String offerId, String ipAddress) throws IOException;

	/**
	 * Gets access status (async)<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncGetAccessStatusRequest objects
	 * @return
	 */
	public void getAccessStatusAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Get accessible tags.<br/>
	 * <br/>
	 *
	 * @param publisherToken publisher's token
	 * @param customerToken customer's token
	 * @return
	 */
	GetAccessibleTagsResponse getAccessibleTags(String publisherToken, String customerToken) throws IOException;

	/**
	 * Gets accessible tags (async)<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncGetAccessibleTagsRequest objects
	 * @return
	 */
	void getAccessibleTagsAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Get customer<br/>
	 * <br/>
	 *
	 * @param customerToken customer's token
	 * @return
	 */
	GetCustomerResponse getCustomer(String customerToken) throws IOException;

	/**
	 * Get customer (async)<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncRequest objects
	 * @return
	 */
	void getCustomerAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Creates Vod offer<br/>
	 * <br/>
	 *
	 * @param offerData vod offer data
	 * @return
	 */
	VodOfferResponse createVodOffer(VodOfferData offerData) throws IOException;

	/**
	 * Creates Vod offer (async)<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncRequest objects
	 * @return
	 */
	void createVodOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Gets Vod offer<br/>
	 * <br/>
	 *
	 * @param offerId an id of an offer
	 * @return
	 */
	public VodOfferResponse getVodOffer(String offerId) throws IOException;

	/**
	 * Gets Vod offer (async)<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncRequest objects
	 * @return
	 */
	public void getVodOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Updates Vod offer<br/>
	 * <br/>
	 *
	 * @param offerId offer id
	 * @param offerData vod offer data
	 * @return
	 */
	public VodOfferResponse updateVodOffer(String offerId, VodOfferData offerData) throws IOException;

	/**
	 * Updates Vod offer(s) (async)<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncRequest objects
	 * @return
	 */
	public void updateVodOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Generates a checkout url
	 *
	 * @param customerEmail vod offer data
	 *
	 * @return
	 * @throws IOException
	 */
	public UrlResponse generateCheckoutUrl(String customerEmail, FlowDescription flowDescription) throws IOException;

	/**
	 * Generates checkout urls (async)<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncRequest objects
	 * @return
	 */
	public void generateCheckoutUrlAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Registers a customer
	 *
	 * @param data customer data
	 *
	 * @return
	 * @throws IOException
	 */
	public TokenResponse registerCustomer(CustomerData data) throws IOException;

	/**
	 * Registers customers (async)<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncRequest objects
	 * @return
	 */
	public void registerCustomerAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Generates my account url<br/>
	 * <br/>
	 *
	 * @param customerEmail customer email
	 * @param modules lis of modules
	 * @return
	 */
	UrlResponse generateMyAccountUrl(String customerEmail, List<String> modules) throws IOException;

	/**
	 * Generates my account url (async)<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncRequest objects
	 * @return
	 */
	void generateMyAccountUrlAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Gets offerIds by video id<br/>
	 * <br/>
	 *
	 * @param videoId video Id
	 * @return
	 */
	ListOfferIdsByVideoIdResponse listOfferIdsByVideoId(String videoId) throws IOException;

	/**
	 * Gets offerIds by video id (async)<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncRequest objects
	 * @return
	 */
	void listOfferIdsByVideoIdAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Checks whether access to offer is granted<br/>
	 * <br/>
	 *
	 * @param customerToken customer token
	 * @param offerId offer id
	 * @param deviceId device id
	 * @param deviceType device type
	 * @return
	 */
	GetAccessStatusForDeviceResponse getAccessStatusForDevice(String customerToken, String offerId, String deviceId, String deviceType) throws IOException;

	/**
	 * Checks whether access to offer is granted<br/>
	 * <br/>
	 *
	 * @param requests collection of AsyncRequest objects
	 * @return
	 */
	void getAccessStatusForDeviceAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Invokes a batch request (async)<br/>
	 * <br/>
	 *
	 * @param batch object containing a collection of individual requests
	 * @return
	 */
	void invokeBatchAsync(BatchAsyncRequest batch) throws IOException, InterruptedException;

	/**
	 * Invokes a batch request<br/>
	 * <br/>
	 *
	 * @param batch object containing a collection of individual requests
	 * @return
	 */
	public BatchResponse invokeBatch(BatchRequest batch) throws IOException;
}
