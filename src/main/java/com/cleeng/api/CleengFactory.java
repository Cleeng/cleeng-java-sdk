package com.cleeng.api;

import java.net.MalformedURLException;

/**
 * Factory to create {@link Cleeng} instances to interact with Cleeng production
 * and sandbox plarforms.
 * 
 */
public class CleengFactory {

	final static String SANDBOX_URL = "https://sandbox.cleeng.com";
	final static String PRODUCTION_URL = "https://cleeng.com";

	public static Cleeng createSandboxApi() throws MalformedURLException {
		return new CleengImpl(SANDBOX_URL);
	}

	public static Cleeng createSandboxApi(String publisherToken)
			throws MalformedURLException {
		return new CleengImpl(SANDBOX_URL, publisherToken);
	}

	public static Cleeng createProductionApi() throws MalformedURLException {
		return new CleengImpl(PRODUCTION_URL);
	}

	public static Cleeng createProductionApi(String publisherToken)
			throws MalformedURLException {
		return new CleengImpl(PRODUCTION_URL, publisherToken);
	}
}
