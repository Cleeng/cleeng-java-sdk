[![Cleeng](https://cdn-statics.cleeng.com/branding/images/cleeng-logo.png?v=634f83148f)](http://www.cleeng.com)

# Cleeng Java SDK
[![Build Status](https://travis-ci.org/Cleeng/cleeng-java-sdk.svg?branch=master)](https://travis-ci.org/Cleeng/cleeng-java-sdk)
[![Coverage Status](https://coveralls.io/repos/github/Cleeng/cleeng-java-sdk/badge.svg?branch=master)](https://coveralls.io/github/Cleeng/cleeng-java-sdk?branch=master)

Full Java SDK you can find here: https://github.com/Cleeng/cleeng-java-sdk/
---
# SDK Configuration
You can configure the SDK with CleengBuilder class by either providing the path to config.properties file or by using setters related to configuration properties. Below is the default config file with configuration properties:
```
socketTimeout=3000
connectTimeout=400
requestTimeout=3000
retryCount=10
useNonBlockingMode=true
platformUrl=https://cleeng.com/api/3.0/json-rpc
platformUrlSandbox=https://sandbox.cleeng.com/api/3.0/json-rpc
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
## platformUrl
Determines the URL of the production platform.
## platformUrlSandbox
Determines the URL of the sandbox platform.

---
# Logging
Cleeng Java SDK depends on Log4J in order to provide logging capability. It is configured to log events to both the system console and cleeng.log file, which can be found in a folder containing the SDK build.
Log4J configuration for the SDK can be found in 'src/main/resources'. Feel free to remove ```<AppenderRef ref="File"/>``` elements in order to stop logging to a file.
```
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <Properties>
        <Property name="filename">target/cleeng.log</Property>
    </Properties>
    <Appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
        <File name="File" fileName="${filename}">
            <PatternLayout>
                <pattern>%d %p %C{1.} [%t] %m%n</pattern>
            </PatternLayout>
        </File>
    </Appenders>
    <Loggers>
        <Root level="error">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="File"/>
        </Root>
        <Root level="warn">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="File"/>
        </Root>
        <Root level="info">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="File"/>
        </Root>
    </Loggers>
</Configuration>
```

---
# Example usage with synchronous/blocking method call
```
// Initialize API with the config.properties path. As an example, the code below overrides the retry count and connect timeout settings.
    Cleeng api = return new CleengBuilder("IEiuf3fJzAorVvxgBYiHiHXGk8oFPckTMSOn8hS1--lOti30")
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
# Example usage with asynchronous/non blocking method call
```
// Initialize API
    Cleeng api = return new CleengBuilder("IEiuf3fJzAorVvxgBYiHiHXGk8oFPckTMSOn8hS1--lOti30")
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
---
# Example asynchronous/non blocking batch request usage
```
// Initialize API
    Cleeng api = return new CleengBuilder("IEiuf3fJzAorVvxgBYiHiHXGk8oFPckTMSOn8hS1--lOti30")
        .setPropertiesPath("src/main/resources/config.properties")
        .build();

// Construct request payload
	SubscriptionOfferData offerData = new SubscriptionOfferData(12.34,
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

// Create requests
	OfferRequest createOffer = new OfferRequest("createSubscriptionOffer", OfferParams.create(publisherToken, offerData));
	ListRequest listOffers = new ListRequest("listSubscriptionOffers", ListParams.create(publisherToken, new Criteria(true), 0, 10));

// Construct batch
	BatchAsyncRequest batch = new BatchAsyncRequest();

// Insert requests to batch
	batch.addRequest(createOffer);
	batch.addRequest(listOffers);

// Exectute an asynchronous, non blocking batch call.
	api.invokeBatchAsync(batch);

// Once batch request completes, BatchResponse is available through getResponse() method call.
	TimeUnit.SECONDS.sleep(4);
	BatchResponse response = batch.getResponse();
```
---
# Example synchronous/blocking batch request usage
```
// Initialize API
    Cleeng api = return new CleengBuilder("IEiuf3fJzAorVvxgBYiHiHXGk8oFPckTMSOn8hS1--lOti30")
        .setPropertiesPath("src/main/resources/config.properties")
        .build();

// Construct request payload
	SubscriptionOfferData offerData = new SubscriptionOfferData(12.34,
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

// Create requests
	OfferRequest createOffer = new OfferRequest("createSubscriptionOffer", OfferParams.create(publisherToken, offerData));
	ListRequest listOffers = new ListRequest("listSubscriptionOffers", ListParams.create(publisherToken, new Criteria(true), 0, 10));

// Construct batch
	BatchRequest batch = new BatchRequest();

// Insert requests to batch
	batch.addRequest(createOffer);
	batch.addRequest(listOffers);

// Exectute an synchronous/blocking batch call.
	BatchResponse = api.invokeBatch(batch);
```
# Notes
The Cleeng Java SDK is accompanied by the strong battery of unit tests. See src/test/java/com/cleeng/api/CleengImplTest.java for detailed information on how to construct request payloads and invoke specific methods. See [API Reference](https://developers.cleeng.com/v3/Reference) for details on the Cleeng API.

All functions in the API documentation have been implemented as public methods on a class implementing Cleeng interface.

There are two basic kinds of these methods, synchronous ones and their asynchronous sibilings that can be recognized by the 'async' suffix in the method name.

There is also a way to send a collection of different requests in one batch through either 'invokeBatchAsync' or 'invokeBatch' methods. Please see "Example asynchronous/non blocking batch request usage" and "Example synchronous/blocking batch request usage" sections above.

Instead of duplicating all class & type information once more in this file, please refer to the file src/main/java/com/cleeng/api/Cleeng.java for the method signatures, and to src/main/java/com/cleeng/api/domain/*.java for the classes used for parameters and return values. The names map directly to the documentation available at API Reference.

Note that most error conditions raise exceptions which have to be handled properly by you, the programmer.

# Building the SDK
The Cleeng Java SDK can be built from the source code with Maven. In order to make a clean build, execute ```mvn clean install``` command. This command will download all required dependencies, compile the SDK, package it to ```cleeng-java-sdk-{version}-jar-with-dependencies.jar``` file and place it in your local Maven repository ($HOME/.m2/ by default).

There are a few example Java programs in the jar file, that you can run as follows:

```java -cp path/to/cleeng-java-sdk-{version}-jar-with-dependencies.jar com/cleeng/api/examples/CleengJavaAPIExample```

```java -cp path/to/cleeng-java-sdk-{version}-jar-with-dependencies.jar com/cleeng/api/examples/CleengJavaAPIExampleAsync```

```java -cp path/to/cleeng-java-sdk-{version}-jar-with-dependencies.jar com/cleeng/api/examples/CleengJavaAPIBatchExample```

```java -cp path/to/cleeng-java-sdk-{version}-jar-with-dependencies.jar com/cleeng/api/examples/CleengJavaAPIBatchExampleAsync```



