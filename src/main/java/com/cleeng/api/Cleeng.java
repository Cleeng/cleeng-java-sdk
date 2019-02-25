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
	 * Creates a subscription offer.
	 *
	 *
	 * @param offerData domain object representing offer data
	 * @return offer response
	 * @throws IOException if I/O exception occurred
	 */
	OfferResponse createSubscriptionOffer(SubscriptionOfferData offerData) throws IOException;

	/**
	 * Creates subscription offers (async)
	 *
	 *
	 * @param requests request objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void createSubscriptionOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Updates a subscription offer.
	 *
	 *
	 * @param offerData domain object representing offer data
	 * @param offerId offer id
	 * @throws IOException if I/O exception occurred
	 * @return offer response
	 */
	OfferResponse updateSubscriptionOffer(SubscriptionOfferData offerData, String offerId) throws IOException;

	/**
	 * Updates subscription offers (async)
	 *
	 *
	 * @param requests requests
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void updateSubscriptionOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Creates a single offer.
	 *
	 *
	 * @param offerData domain object representing single offer data
	 * @throws IOException if I/O exception occurred
	 * @return Single offer response
	 */
	SingleOfferResponse createSingleOffer(SingleOfferData offerData) throws IOException;

	/**
	 * Creates single offers (async)
	 *
	 *
	 * @param requests request objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void createSingleOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Updates a single offer.
	 *
	 * @param offerId offer Id
	 * @param offerData domain object representing single offer data
	 * @throws IOException if I/O exception occurred
	 * @return Single offer response
	 */
	SingleOfferResponse updateSingleOffer(String offerId, SingleOfferData offerData) throws IOException;

	/**
	 * Updates single offers (async)
	 *
	 *
	 * @param requests request objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void updateSingleOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Creates an event offer.
	 *
	 *
	 * @param offerData domain object representing event offer data
	 * @throws IOException if I/O exception occurred
	 * @return event offer response
	 */
	EventOfferResponse createEventOffer(EventOfferData offerData) throws IOException;

	/**
	 * Creates an event offers (async).
	 *
	 *
	 * @param requests request objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void createEventOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Updates an event offer.
	 *
	 *
	 * @param offerData domain object representing event offer data
	 * @param offerId offer Id
	 * @throws IOException if I/O exception occurred
	 * @return event offer response
	 */
	EventOfferResponse updateEventOffer(EventOfferData offerData, String offerId) throws IOException;

	/**
	 * Updates event offers (async)
	 *
	 *
	 * @param requests request objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void updateEventOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Creates a rental offer.
	 *
	 *
	 * @param offerData domain object representing rental offer data
	 * @throws IOException if I/O exception occurred
	 * @return rental offer response
	 */
	RentalOfferResponse createRentalOffer(RentalOfferData offerData) throws IOException;

	/**
	 * Creates rental offers (async).
	 *
	 *
	 * @param requests request objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void createRentalOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Updates a rental offer.
	 *
	 *
	 * @param offerData domain object representing rental offer data
	 * @param offerId offer Id
	 * @throws IOException if I/O exception occurred
	 * @return Rental Offer Response
	 */
	RentalOfferResponse updateRentalOffer(RentalOfferData offerData, String offerId) throws IOException;

	/**
	 * Updates rental offers (async)
	 *
	 *
	 * @param requests request objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void updateRentalOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Creates a pass offer.
	 *
	 *
	 * @param offerData domain object representing pass offer data
	 * @throws IOException if I/O exception occurred
	 * @return pass offer response
	 */
	PassOfferResponse createPassOffer(PassOfferData offerData) throws IOException;

	/**
	 * Updates a pass offer.
	 *
	 *
	 * @param offerData domain object representing pass offer data
	 * @param offerId offer Id
	 * @throws IOException if I/O exception occurred
	 * @return offer response
	 */
	OfferResponse updatePassOffer(PassOfferData offerData, String offerId) throws IOException;

	/**
	 * Updates pass offers (async)
	 *
	 *
	 * @param requests request objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void updatePassOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Creates pass offers (async).
	 *
	 *
	 * @param requests request objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void createPassOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Lists subscription offers.
	 *
	 *
	 * @param criteria domain object representing search criteria
	 * @param offset pagination offset
	 * @param limit pagination's items per page
	 * @throws IOException if I/O exception occurred
	 * @return list subscription offers response
	 */
	ListSubscriptionOffersResponse listSubscriptionOffers(Criteria criteria, int offset, int limit) throws IOException;

	/**
	 * Lists subscription offers (async).
	 *
	 *
	 * @param requests collection of AsyncListRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void listSubscriptionOffersAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Lists single offers.
	 *
	 *
	 * @param criteria domain object representing search criteria
	 * @param offset pagination offset
	 * @param limit pagination's items per page
	 * @throws IOException if I/O exception occurred
	 * @return list of single offers response
	 */
	ListSingleOffersResponse listSingleOffers(Criteria criteria, int offset, int limit) throws IOException;

	/**
	 * Lists single offers (async).
	 *
	 *
	 * @param requests collection of AsyncListRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void listSingleOffersAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Lists vod offers.
	 *
	 *
	 * @param criteria domain object representing search criteria
	 * @param offset pagination offset
	 * @param limit pagination's items per page
	 * @throws IOException if I/O exception occurred
	 * @return list vod offers response
	 */
	ListVodOffersResponse listVodOffers(Criteria criteria, int offset, int limit) throws IOException;

	/**
	 * Lists vod offers (async).
	 *
	 *
	 * @param requests collection of AsyncListRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void listVodOffersAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Lists pass offers.
	 *
	 *
	 * @param criteria domain object representing search criteria
	 * @param offset pagination offset
	 * @param limit pagination's limit
	 * @throws IOException if I/O exception occurred
	 * @return list pass offers response
	 */
	ListPassOffersResponse listPassOffers(Criteria criteria, int offset, int limit) throws IOException;

	/**
	 * Lists pass offers (async).
	 *
	 *
	 * @param requests collection of AsyncListRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void listPassOffersAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Prepares a remote auth.
	 *
	 *
	 * @param customerData domain object representing customer's data
	 * @param flowDescription domain object representing flow description
	 * @throws IOException if I/O exception occurred
	 * @return prepare remote auth response
	 */
	PrepareRemoteAuthResponse prepareRemoteAuth(CustomerData customerData, FlowDescription flowDescription) throws IOException;

	/**
	 * Prepares a remote auth (async).
	 *
	 *
	 * @param requests collection of AsyncPrepareRemoteAuthRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void prepareRemoteAuthAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Generates a customer token.
	 *
	 *
	 * @param customerEmail customer's email
	 * @throws IOException if I/O exception occurred
	 * @return token response
	 */
	TokenResponse generateCustomerToken(String customerEmail) throws IOException;

	/**
	 * Generates a customer token (async)
	 *
	 *
	 * @param requests collection of AsyncTokenRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void generateCustomerTokenAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Requests user's password reset.
	 *
	 *
	 * @param customerEmail customer's email
	 * @throws IOException if I/O exception occurred
	 * @return boolean response
	 */
	BooleanResponse requestPasswordReset(String customerEmail) throws IOException;

	/**
	 * Requests user's password reset (async).
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void requestPasswordResetAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Updates user's password.
	 *
	 *
	 * @param customerEmail customer's email
	 * @param resetPasswordToken token received on email
	 * @param newPassword new password
	 * @throws IOException if I/O exception occurred
	 * @return boolean response
	 */
	BooleanResponse updateCustomerPassword(String customerEmail, String resetPasswordToken, String newPassword) throws IOException;

	/**
	 * Updates customer password (async).
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void updateCustomerPasswordAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Updates customer's subscription.
	 *
	 *
	 * @param offerId offer Id
	 * @param customerEmail customer email
	 * @param offerData offer data
	 * @throws IOException if I/O exception occurred
	 * @return update customer subscription response
	 */
	UpdateCustomerSubscriptionResponse updateCustomerSubscription(String offerId, String customerEmail, UpdateCustomerSubscriptionOfferData offerData) throws IOException;

	/**
	 * Updates customer's subscription (async).
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void updateCustomerSubscriptionAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Updates user's email.
	 *
	 *
	 * @param customerEmail customer's email
	 * @param newEmail new email
	 * @throws IOException if I/O exception occurred
	 * @return boolean response
	 */
	BooleanResponse updateCustomerEmail(String customerEmail, String newEmail) throws IOException;

	/**
	 * Updates customer email (async).
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void updateCustomerEmailAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Generates a customer token from facebook.
	 *
	 *
	 * @param facebookId facebook login
	 * @throws IOException if I/O exception occurred
	 * @return token response
	 */
	TokenResponse generateCustomerTokenFromFacebook(String facebookId) throws IOException;

	/**
	 * Generates a customer token from facebook (async)
	 *
	 *
	 * @param requests collection of AsyncTokenRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void generateCustomerTokenFromFacebookAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Generates a customer token from password.
	 *
	 *
	 * @param password password
	 * @param customerEmail customer email
	 * @throws IOException if I/O exception occurred
	 * @return token response
	 */
	TokenResponse generateCustomerTokenFromPassword(String password, String customerEmail) throws IOException;

	/**
	 * Generates a customer token from password (async)
	 *
	 *
	 * @param requests collection of AsyncTokenRequest objects
	 * @throws IOException if I/O exception occurs
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void generateCustomerTokenFromPasswordAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Gets access status.
	 *
	 *
	 * @param customerToken customer token
	 * @param offerId offer Id
	 * @param ipAddress IP address
	 * @throws IOException if I/O exception occurred
	 * @return get access status response
	 */
	GetAccessStatusResponse getAccessStatus(String customerToken, String offerId, String ipAddress) throws IOException;

	/**
	 * Gets access status (async)
	 *
	 *
	 * @param requests collection of AsyncGetAccessStatusRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void getAccessStatusAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Get accessible tags.
	 *
	 *
	 * @param publisherToken publisher's token
	 * @param customerToken customer's token
	 * @throws IOException if I/O exception occurred
	 * @return get accessible tags response
	 */
	GetAccessibleTagsResponse getAccessibleTags(String publisherToken, String customerToken) throws IOException;

	/**
	 * Gets accessible tags (async)
	 *
	 *
	 * @param requests collection of AsyncGetAccessibleTagsRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void getAccessibleTagsAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Get customer
	 *
	 *
	 * @param customerToken customer's token
	 * @throws IOException if I/O exception occurred
	 * @return get customer response
	 */
	GetCustomerResponse getCustomer(String customerToken) throws IOException;

	/**
	 * Get customer (async)
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void getCustomerAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Creates Vod offer
	 *
	 *
	 * @param offerData vod offer data
	 * @throws IOException if I/O exception occurred
	 * @return vod offer response
	 */
	VodOfferResponse createVodOffer(VodOfferData offerData) throws IOException;

	/**
	 * Creates Vod offer (async)
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void createVodOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Gets Vod offer
	 *
	 *
	 * @param offerId an id of an offer
	 * @throws IOException if I/O exception occurred
	 * @return vod offer response
	 */
	VodOfferResponse getVodOffer(String offerId) throws IOException;

	/**
	 * Gets Vod offer (async)
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void getVodOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Updates Vod offer
	 *
	 *
	 * @param offerId offer id
	 * @param offerData vod offer data
	 * @throws IOException if I/O exception occurred
	 * @return vod offer response
	 */
	VodOfferResponse updateVodOffer(String offerId, VodOfferData offerData) throws IOException;

	/**
	 * Updates Vod offer(s) (async)
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void updateVodOfferAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Generates a checkout url
	 *
	 * @param customerEmail customer email
	 * @param flowDescription flow description
	 *
	 * @return url response
	 * @throws IOException if I/O exception occurred
	 */
	UrlResponse generateCheckoutUrl(String customerEmail, FlowDescription flowDescription) throws IOException;

	/**
	 * Generates checkout urls (async)
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void generateCheckoutUrlAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Registers a customer
	 *
	 * @param data customer data
	 *
	 * @return token response
	 * @throws IOException if I/O exception occurred
	 */
	TokenResponse registerCustomer(CustomerData data) throws IOException;

	/**
	 * Registers customers (async)
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void registerCustomerAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Generates my account url
	 *
	 *
	 * @param customerEmail customer email
	 * @param modules a list of modules
	 * @throws IOException if I/O exception occurred
	 * @return url response
	 */
	UrlResponse generateMyAccountUrl(String customerEmail, List<String> modules) throws IOException;

	/**
	 * Generates my account url (async)
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void generateMyAccountUrlAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Lists payment details
	 *
	 *
	 * @param userEmail user's email
	 * @throws IOException if I/O exception occurred
	 * @return payment details response
	 */
	PaymentDetailsResponse listPaymentDetails(String userEmail) throws IOException;

	/**
	 * Lists payment details (async)
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void listPaymentDetailsAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Deletes payment details
	 *
	 *
	 * @param paymentDetailsId Id of payment details
	 * @throws IOException if I/O exception occurred
	 * @return boolean response
	 */
	BooleanResponse deletePaymentDetails(String paymentDetailsId) throws IOException;

	/**
	 * Deletes payment details (async)
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void deletePaymentDetailsAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Checks if trial is allowed
	 *
	 *
	 * @param customerEmail customer's email
	 * @param offerId offer Id
	 * @throws IOException if I/O exception occurred
	 * @return boolean response
	 */
	BooleanResponse isTrialAllowed(String customerEmail, String offerId) throws IOException;

	/**
	 * Checks if trial is allowd (async)
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void isTrialAllowedAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Gets offerIds by video id
	 *
	 *
	 * @param videoId video Id
	 * @throws IOException if I/O exception occurred
	 * @return list offer ids by video id response
	 */
	ListOfferIdsByVideoIdResponse listOfferIdsByVideoId(String videoId) throws IOException;

	/**
	 * Gets offerIds by video id (async)
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void listOfferIdsByVideoIdAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Lists customer subscriptions
	 *
	 *
	 * @param customerEmail customer's email
	 * @param offset pagination offset
	 * @param limit pagination limit
	 * @throws IOException if I/O exception occurred
	 * @return list customer subscriptions response
	 */
	ListCustomerSubscriptionsResponse listCustomerSubscriptions(String customerEmail, int offset, int limit) throws IOException;

	/**
	 * Gets offerIds by video id (async)
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void listCustomerSubscriptionsAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Checks whether access to offer is granted
	 *
	 *
	 * @param customerToken customer token
	 * @param offerId offer id
	 * @param deviceId device id
	 * @param deviceType device type
	 * @throws IOException if I/O exception occurred
	 * @return get access status for device response
	 */
	GetAccessStatusForDeviceResponse getAccessStatusForDevice(String customerToken, String offerId, String deviceId, String deviceType) throws IOException;

	/**
	 * Checks whether access to offer is granted
	 *
	 *
	 * @param requests collection of AsyncRequest objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void getAccessStatusForDeviceAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Invokes a batch request (async)
	 *
	 *
	 * @param batch object containing a collection of individual requests
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void invokeBatchAsync(BatchAsyncRequest batch) throws IOException, InterruptedException;

	/**
	 * Invokes a batch request
	 *
	 *
	 * @param batch object containing a collection of individual requests
	 * @throws IOException if I/O exception occurred
	 * @return batch response
	 */
	BatchResponse invokeBatch(BatchRequest batch) throws IOException;

	/**
	 * Updates Cleeng Capture data for given broadcaster and customer
	 *
	 *
	 * @param userId user Id
	 * @param data object containing personal data
	 * @throws IOException if I/O exception occurred
	 * @return boolean response
	 */
	BooleanResponse updateBroadcasterSpecificPersonalDataWithCaptureAnswers(Integer userId, PersonalData data) throws IOException;

	/**
	 * Updates Cleeng Capture data for given broadcaster and customer in an asynchronous way
	 *
	 * @param requests request objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void updateBroadcasterSpecificPersonalDataWithCaptureAnswersAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * fetches customer data with additional broadcaster specific information
	 *
	 *
	 * @param userId user's Id
	 * @throws IOException if I/O exception occurred
	 * @return personal data response
	 */
	PersonalDataResponse fetchBroadcasterSpecificPersonalDataWithCaptureAnswers(Integer userId) throws IOException;

	/**
	 * Fetches customer data with additional broadcaster specific information in an asynchronous way
	 *
	 * @param requests request objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void fetchBroadcasterSpecificPersonalDataWithCaptureAnswersAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Saves capture questions
	 *
	 * @param questions a list of questions
	 * @return boolean response
	 * @throws IOException if I/O exception occurred
	 */
	BooleanResponse saveCaptureQuestions(List<Question> questions) throws IOException;

	/**
	 * Saves capture questions in an asynchronous way
	 *
	 * @param requests request objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void saveCaptureQuestionsAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;

	/**
	 * Fetches capture questions
	 *
	 * @return capture question response
	 * @throws IOException if I/O exception occurred
	 */
	CaptureQuestionResponse fetchCaptureQuestions() throws IOException;

	/**
	 * Fetches capture questions in an asynchronous way
	 *
	 * @param requests request objects
	 * @throws IOException if I/O exception occurred
	 * @throws InterruptedException if operation thread is interrupted
	 */
	void fetchCaptureQuestionsAsync(List<AsyncRequest> requests) throws IOException, InterruptedException;
}
