package com.cleeng.api;

import com.cleeng.api.domain.*;

import java.io.IOException;

/**
 * Cleeng API. Set of methods to interact with Cleeng platform.
 * 
 */
public interface Cleeng {

	/**
	 * Creates a subscription offer.<br/>
	 * <br/>
	 *
	 * @param offerData
	 * @return
	 */
	OfferResponse createSubscriptionOffer(OfferData offerData) throws IOException;

	/**
	 * Creates a single offer.<br/>
	 * <br/>
	 *
	 * @param offerData
	 * @return
	 */
	SingleOfferResponse createSingleOffer(SingleOfferData offerData) throws IOException;

	/**
	 * Creates an event offer.<br/>
	 * <br/>
	 *
	 * @param offerData
	 * @return
	 */
	EventOfferResponse createEventOffer(EventOfferData offerData) throws IOException;

	/**
	 * Creates a rental offer.<br/>
	 * <br/>
	 *
	 * @param offerData
	 * @return
	 */
	RentalOfferResponse createRentalOffer(RentalOfferData offerData) throws IOException;

	/**
	 * Creates a pass offer.<br/>
	 * <br/>
	 *
	 * @param offerData
	 * @return
	 */
	PassOfferResponse createPassOffer(PassOfferData offerData) throws IOException;

	/**
	 * Lists subscription offers.<br/>
	 * <br/>
	 *
	 * @param criteria
	 * @param offset
	 * @param limit
	 * @return
	 */
	ListSubscriptionOffersResponse listSubscriptionOffers(Criteria criteria, int offset, int limit) throws IOException;

	/**
	 * Lists single offers.<br/>
	 * <br/>
	 *
	 * @param criteria
	 * @param offset
	 * @param limit
	 * @return
	 */
	ListSingleOffersResponse listSingleOffers(Criteria criteria, int offset, int limit) throws IOException;

	/**
	 * Lists pass offers.<br/>
	 * <br/>
	 *
	 * @param criteria
	 * @param offset
	 * @param limit
	 * @return
	 */
	ListPassOffersResponse listPassOffers(Criteria criteria, int offset, int limit) throws IOException;

	/**
	 * Prepares a remote auth.<br/>
	 * <br/>
	 *
	 * @param customerData
	 * @param flowDescription
	 * @return
	 */
	PrepareRemoteAuthResponse prepareRemoteAuth(CustomerData customerData, FlowDescription flowDescription) throws IOException;


	/**
	 * Generates a customer token.<br/>
	 * <br/>
	 *
	 * @param customerEmail
	 * @return
	 */
	GenerateCustomerTokenResponse generateCustomerToken(String customerEmail) throws IOException;
}
