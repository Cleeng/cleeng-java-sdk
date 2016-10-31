package com.cleeng.api;

import com.cleeng.api.domain.OfferData;
import com.cleeng.api.domain.OfferResponse;
import com.cleeng.api.domain.SingleOfferData;
import com.cleeng.api.domain.SingleOfferResponse;

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







}
