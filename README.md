Cleeng Java SDK
===============

See https://developers.cleeng.com/v3/Reference for details on the Cleeng API.

Example usage:

	// Initialize API
    Cleeng api = return new CleengBuilder("https://sandbox.cleeng.com/api/3.0/json-rpc", "IEiuf3fJzAorVvxgBYiHiHXGk8oFPckTMSOn8hS1--lOti30")
    				.setPropertiesPath("src/main/resources/config.properties")
  					.setUseNonBlockingMode(1)
  					.setSocketTimeout(3000)
  					.setConnectTimeout(5000)
  					.setRetryCount(10)
                    .build();

	// Create subscription offer
    final SubscriptionOfferData offerData = new SubscriptionOfferData(12.34,
		"week",
		"title",
		"http://www.someurl.com",
		"description",
		null,
		0,
		9,
		Arrays.asList("Sport"),
		true,
		"whitelist",
		Arrays.asList("PL", "DE")
    );

    final OfferResponse response = this.api.createSubscriptionOffer(offerData);

	// Prepare remote authentication

	final CustomerData customerData = new CustomerData("johndoe@gmail.com", "en_US", "GBP", "PL");
    final FlowDescription flowDescription = new FlowDescription("8", "http://www.someurl.com");
    final PrepareRemoteAuthResponse authResponse = this.api.prepareRemoteAuth(customerData, flowDescription);

    // Execute two calls in an asynchronous way

	final PassOfferData offerData = new PassOfferData(12.34,
			null,
			1900000000,
			"title",
			"http://www.someurl.com",
			null,
			"description",
			Arrays.asList("Sport"),
			true,
			"whitelist",
			Arrays.asList("PL","DE")
	);

	final AsyncRequestCallback<PassOfferResponse> callback = new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class);
	final AsyncRequestCallback<PassOfferResponse> secondCallback = new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class);

	final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
	requests.add(new AsyncRequest(offerData, callback));
	requests.add(new AsyncRequest(offerData, secondCallback));

	this.api.createPassOfferAsync(requests);
