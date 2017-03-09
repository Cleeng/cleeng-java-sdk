# Cleeng Java SDK
[![Cleeng](https://cdn-statics.cleeng.com/branding/images/cleeng-logo.png?v=634f83148f)](http://www.cleeng.com)
Full Java SDK you can find here: https://github.com/Cleeng/cleeng-java-sdk/
---
# SDK Configuration
You can configure the SDK with CleengBuilder class by either providing the path to config.properties file or by using setters related to configuration properties. Below is the default config file with configuration properties:
```
socketTimeout=3000
connectTimeout=100
requestTimeout=3000
retryCount=10
useNonBlockingMode=true
```
## socketTimeout
Defines the socket timeout in milliseconds, which is the timeout for waiting for data or, put differently, a maximum period inactivity between two consecutive data packets). This configuration setting only applies to synchronous method calls.
## connectTimeout
Determines the timeout in milliseconds until a connection is established. This configuration setting applies to both synchronous and asynchronous method calls.
## requestTimeout
Determines the maximum time in millisecond the callback waits until the response is completed. This configuration setting only applies to asynchronous method calls.
## retryCount
Determines the number of time the library will retry when an exception is throw by the remote http server. This configuration setting applies to both synchronous and asynchronous method calls.
## useNonBlockingMode
Determines whether to block the code execution until request completes. This setting only applies to asynchronous methods, as synchronous ones are blocking only.

---
# Example usage with synchronous, blocking method call:
```
// Initialize API with the config.properties path. As an example, the code below overrides the retry count and connect timeout settings.
    Cleeng api = return new CleengBuilder("https://sandbox.cleeng.com/api/3.0/json-rpc", "IEiuf3fJzAorVvxgBYiHiHXGk8oFPckTMSOn8hS1--lOti30")
        .setPropertiesPath("src/main/resources/config.properties")
        .setConnectTimeout(200)
  		.setRetryCount(20)
        .build();

// Construct the request payload
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

// Exectute a synchronous, blocking http call
	final OfferResponse response = this.api.createSubscriptionOffer(offerData);
```
---
# Example usage with asynchronous, non blocking method call:
```
// Initialize API
    Cleeng api = return new CleengBuilder("https://sandbox.cleeng.com/api/3.0/json-rpc", "IEiuf3fJzAorVvxgBYiHiHXGk8oFPckTMSOn8hS1--lOti30")
        .setPropertiesPath("src/main/resources/config.properties")
        .build();

// Construct the request payload
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

// Declare the callback, use it to construct the AsyncRequest
    final AsyncRequestCallback<OfferResponse> callback = new AsyncRequestCallback<OfferResponse>(OfferResponse.class);
    final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
    requests.add(new AsyncRequest(offerData, callback));

// Exectute an asynchronous, non blocking http call
    this.api.createSubscriptionOfferAsync(requests);
```
# Notes
The Cleeng Java SDK is accompanied by the strong battery of unit tests. See src/test/java/com/cleeng/api/CleengImplTest.java for detailed information on how to construct request payloads and invoke specific methods. See [API Reference](https://developers.cleeng.com/v3/Reference) for details on the Cleeng API.

All functions in the API documentation have been implemented as public methods on a class implementing Cleeng interface.

There are two kinds of these methods, synchronous ones and their asynchronous sibilings that can be recognized by the 'async' suffix in the method name.

Instead of duplicating all class & type information once more in this file, please refer to the file src/main/java/com/cleeng/api/Cleeng.java for the method signatures, and to src/main/java/com/cleeng/api/domain/*.java for the classes used for parameters and return values. The names map directly to the documentation available at API Reference.

Note that most error conditions raise exceptions which have to be handled properly by you, the programmer.

# Building the SDK
The Cleeng Java SDK can be built from the source code with Maven. In order to make a clean build, execute ```mvn clean install```. This command will download all required dependencies, compile the SDK and package it to ```cleeng-java-sdk-{version}-jar-with-dependencies.jar``` file and place it in your local Maven repository ($HOME/.m2/ by default).

There are a few example Java programs in the jar file, that you can run as follows:

```java -cp path/to/cleeng-java-sdk-{version}-jar-with-dependencies.jar com/cleeng/api/examples/CleengJavaAPIExample```

```java -cp path/to/cleeng-java-sdk-{version}-jar-with-dependencies.jar com/cleeng/api/examples/CleengJavaAPIExampleAsync```









