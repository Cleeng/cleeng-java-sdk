package com.cleeng.api;

import java.net.MalformedURLException;
import java.net.URL;

import com.cleeng.api.domain.AccessStatus;
import com.cleeng.api.domain.ItemOffer;
import com.cleeng.api.domain.ItemOfferRequest;
import com.cleeng.api.domain.UserInfo;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.ProxyUtil;

/**
 * Client implementation of Cleeng JSON-RPC API based on <a
 * href="http://code.google.com/p/jsonrpc4j/">jsonrpc4j</a> library.
 * 
 */
public class CleengImpl implements Cleeng {

	private String publisherToken;
	private String platformUrl;
	private CleengRpc cleengRpc;

	private interface CleengRpc {
		ItemOffer createItemOffer(
				@JsonRpcParam(value = "token") String publisherToken,
				@JsonRpcParam(value = "itemOfferData") ItemOfferRequest request);

		ItemOffer updateItemOffer(
				@JsonRpcParam(value = "token") String pubisherToken,
				@JsonRpcParam(value = "itemOfferId") int itemOfferId,
				@JsonRpcParam(value = "itemOfferData") ItemOfferRequest data);

		void removeItemOffer(
				@JsonRpcParam(value = "token") String publisherToken,
				@JsonRpcParam(value = "itemOfferId") int itemOfferId);

		ItemOffer getItemOffer(
				@JsonRpcParam(value = "itemOfferId") int itemOfferId);

		AccessStatus getAccessStatus(
				@JsonRpcParam(value = "token") String token,
				@JsonRpcParam(value = "itemOfferId") int itemOfferId);

		UserInfo getUserInfo(@JsonRpcParam(value = "token") String token);
	}

	public CleengImpl(final String platformUrl) throws MalformedURLException {
		this.platformUrl = platformUrl;
		JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(platformUrl));
		cleengRpc = ProxyUtil.createProxy(getClass().getClassLoader(),
				CleengRpc.class, client);
	}

	public CleengImpl(String platformUrl, String publisherToken)
			throws MalformedURLException {
		this(platformUrl);
		this.publisherToken = publisherToken;
	}

	public ItemOffer createItemOffer(ItemOfferRequest request) {
		return cleengRpc.createItemOffer(this.publisherToken, request);
	}

	public ItemOffer updateItemOffer(int itemOfferId, ItemOfferRequest data) {
		return cleengRpc
				.updateItemOffer(this.publisherToken, itemOfferId, data);
	}

	public void removeItemOffer(int itemOfferId) {
		cleengRpc.removeItemOffer(this.publisherToken, itemOfferId);
	}

	public ItemOffer getItemOffer(int itemOfferId) {
		return cleengRpc.getItemOffer(itemOfferId);
	}

	public AccessStatus getAccessStatus(String customerToken, int itemOfferId) {
		return cleengRpc.getAccessStatus(customerToken, itemOfferId);
	}

	public boolean isAccessGranted(String customerToken, int itemOfferId) {
		return getAccessStatus(customerToken, itemOfferId).getAccessGranted();
	}

	public UserInfo getUserInfo(String customerToken) {
		return cleengRpc.getUserInfo(customerToken);
	}

	public String getPlatformUrl() {
		return platformUrl;
	}

	public void setPlatformUrl(final String platformUrl) {
		this.platformUrl = platformUrl;
	}

	public void setPublisherToken(final String publisherToken) {
		this.publisherToken = publisherToken;
	}

	public String getPublisherToken() {
		return this.publisherToken;
	}

}
