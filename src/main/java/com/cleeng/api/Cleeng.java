package com.cleeng.api;

import com.cleeng.api.domain.*;
import org.apache.http.HttpResponse;
import org.apache.http.concurrent.FutureCallback;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Cleeng API. Set of methods to interact with Cleeng platform.
 * 
 */
public interface Cleeng {

	/**
	 * Creates a subscription offer.<br/>
	 * <br/>
	 *
	 * @param offerData domain object representing offer data
	 * @return
	 */
	OfferResponse createSubscriptionOffer(SubscriptionOfferData offerData) throws IOException;

	void createSubscriptionOfferAsync(SubscriptionOfferData offerData, FutureCallback<HttpResponse> callback, CountDownLatch latch) throws IOException, InterruptedException;

	/**
	 * Creates a single offer.<br/>
	 * <br/>
	 *
	 * @param offerData domain object representing single offer data
	 * @return
	 */
	SingleOfferResponse createSingleOffer(SingleOfferData offerData) throws IOException;

	/**
	 * Creates an event offer.<br/>
	 * <br/>
	 *
	 * @param offerData domain object representing event offer data
	 * @return
	 */
	EventOfferResponse createEventOffer(EventOfferData offerData) throws IOException;

	/**
	 * Creates a rental offer.<br/>
	 * <br/>
	 *
	 * @param offerData domain object representing rental offer data
	 * @return
	 */
	RentalOfferResponse createRentalOffer(RentalOfferData offerData) throws IOException;

	/**
	 * Creates a pass offer.<br/>
	 * <br/>
	 *
	 * @param offerData domain object representing pass offer data
	 * @return
	 */
	PassOfferResponse createPassOffer(PassOfferData offerData) throws IOException;

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
	 * Prepares a remote auth.<br/>
	 * <br/>
	 *
	 * @param customerData domain object representing customer's data
	 * @param flowDescription domain object representing flow description
	 * @return
	 */
	PrepareRemoteAuthResponse prepareRemoteAuth(CustomerData customerData, FlowDescription flowDescription) throws IOException;

	/**
	 * Generates a customer token.<br/>
	 * <br/>
	 *
	 * @param customerEmail customer's email
	 * @return
	 */
	GenerateCustomerTokenResponse generateCustomerToken(String customerEmail) throws IOException;

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
	 * Get accessible tags.<br/>
	 * <br/>
	 *
	 * @param publisherToken publisher's token
	 * @param customerToken customer's token
	 * @return
	 */
	GetAccessibleTagsResponse getAccessibleTags(String publisherToken, String customerToken) throws IOException;
}
