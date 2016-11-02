Cleeng Java SDK
===============

See https://developers.cleeng.com/v3/Reference for details on the Cleeng API.

Example usage:

	// Initialize API
	String publisherToken = "MyPublisherToken";
	Cleeng api = CleengFactory.createProductionApi( publisherToken );

	// Create subscription offer
	final SubscriptionOfferData offerData = new SubscriptionOfferData(12.34,
			"week",
			"some title",
			"http://www.youtube.com",
			"desc",
			0,
			0,
			Arrays.asList("sport"),
			true,
			"whitelist",
			Arrays.asList("PL")
	);

	final SubscriptionOfferResponse response = this.api.createSubscriptionOffer( offerData );

	// Prepare remote authentication

	final CustomerData customerData = new CustomerData( "johndoe@gmail.com", "en_US", "GBP", "PL" );
    final FlowDescription flowDescription = new FlowDescription( 8, "http://www.youtube.com" );
    final PrepareRemoteAuthResponse authResponse = this.api.prepareRemoteAuth( customerData, flowDescription );
