package com.cleeng.api;

/**
 * Factory to create {@link Cleeng} instances to interact with Cleeng production
 * and sandbox plarforms.
 * 
 */
public class CleengFactory {

	public static Cleeng createSandboxApi(String publisherToken) {
		return new CleengBuilder(publisherToken)
				.setUseNonBlockingMode(1)
				.setUseSandbox(true)
				.build();
	}

	public static Cleeng createProductionApi(String publisherToken) {
		return new CleengBuilder(publisherToken)
				.setUseNonBlockingMode(1)
				.build();
	}
}
