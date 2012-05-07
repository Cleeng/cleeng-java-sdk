package com.cleeng.api;

import com.cleeng.api.domain.AccessStatus;
import com.cleeng.api.domain.ItemOffer;
import com.cleeng.api.domain.ItemOfferRequest;
import com.cleeng.api.domain.UserInfo;

/**
 * Cleeng API. Set of methods to interact with Cleeng platform.
 * 
 */
public interface Cleeng {

	/**
	 * Creates reference to item you want to sell on Cleeng servers.<br/>
	 * <br/>
	 * 
	 * In order to use it, you must set publisher token first. You can use one
	 * of:
	 * <ul>
	 * <li>{@link Cleeng#setPublisherToken(String)}</li>
	 * <li>{@link CleengFactory#createProductionApi(String)}</li>
	 * <li>{@link CleengFactory#createSandboxApi(String)}</li>
	 * </ul>
	 * 
	 * @param itemOffer
	 * @return
	 */
	ItemOffer createItemOffer(ItemOfferRequest itemOffer);

	/**
	 * Updates given item offer.
	 * 
	 * @param itemOfferId
	 *            Id of item offer that needs to be updated
	 * @param itemOffer
	 * @return
	 */
	ItemOffer updateItemOffer(int itemOfferId, ItemOfferRequest itemOffer);

	/**
	 * Removes the given item offer.<br/>
	 * <br/>
	 * 
	 * Please note that removeItemOffer doesn't really remove anything from
	 * Cleeng servers - it only marks given item offer as "removed".
	 * 
	 * @param itemOfferId
	 */
	void removeItemOffer(int itemOfferId);

	/**
	 * Returns information about given item offer.
	 * 
	 * @param itemOfferId
	 * @return
	 */
	ItemOffer getItemOffer(int itemOfferId);

	/**
	 * Returns set of properties describing relation between customer and item.
	 * 
	 * @param customerToken As stored in the "CleengClientAccessToken" cookie
	 * @param itemOfferId
	 * @return
	 */
	AccessStatus getAccessStatus(String customerToken, int itemOfferId);

	/**
	 * Returns true if user has an access to given item offer.<br/>
	 * <br/>
	 * 
	 * Internally this function makes a call to
	 * {@link Cleeng#getAccessStatus(int)}.
	 * 
	 * @param customerToken As stored in the "CleengClientAccessToken" cookie
	 * @param itemOfferId
	 * @return
	 */
	boolean isAccessGranted(String customerToken, int itemOfferId);

	/**
	 * Returns available information that describes customer browsing your site.
	 * 
	 * @param customerToken As stored in the "CleengClientAccessToken" cookie
	 * @return
	 */
	UserInfo getUserInfo(String customerToken);

	/**
	 * Returns URL of the platform that is used (e.g. http://cleeng.com or
	 * http://sandbox.cleeng.com).
	 * 
	 * @return
	 */
	String getPlatformUrl();

	/**
	 * Sets the Cleeng platform URL (e.g. http://cleeng.com or
	 * http://sandbox.cleeng.com).
	 * 
	 * @param platformUrl
	 */
	void setPlatformUrl(String platformUrl);

	/**
	 * Returns the publisher token
	 * 
	 * @return
	 */
	String getPublisherToken();

	/**
	 * Sets the publisher token
	 * 
	 * @param publisherToken
	 */
	void setPublisherToken(String publisherToken);
}
