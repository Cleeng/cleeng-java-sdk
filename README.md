Cleeng Java SDK
===============

See http://cleeng.com/open/Reference for details on the Cleeng API.

Example usage:

	// Initialize API
	String publisherToken = "MyPublisherToken";
	Cleeng api = CleengFactory.createProductionApi(publisherToken);

	// Get country based on the customer token (which can be retrieved from the "CleengClientAccessToken" cookie)
	UserInfo userInfo = api.getUserInfo("YourCustomerToken");
	String country = userInfo.getCountry();
