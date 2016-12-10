package com.cleeng.api;

/**
 * Factory to create {@link Cleeng} instances to interact with Cleeng production
 * and sandbox plarforms.
 * 
 */
public class CleengFactory {

	final static String SANDBOX_URL = "https://sandbox.cleeng.com/api/3.0/json-rpc";
	final static String PRODUCTION_URL = "https://cleeng.com/api/3.0/json-rpc";

	public static Cleeng createSandboxApi(String publisherToken) {
		final CleengImpl cleeng = new CleengImpl(SANDBOX_URL, publisherToken);
		cleeng.setNonBlockingMode();
		return cleeng;
	}

	public static Cleeng createProductionApi(String publisherToken) {
		final CleengImpl cleeng = new CleengImpl(PRODUCTION_URL, publisherToken);
		cleeng.setNonBlockingMode();
		return cleeng;
	}
}
