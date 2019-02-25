package com.cleeng.api;

import com.cleeng.api.domain.*;
import com.cleeng.api.domain.async.*;
import org.junit.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

@SuppressWarnings("unchecked")
public class CleengImplTest {

    private String publisherToken = "IEiuf3fJzAorVvxgBYiHiHXGk8oFPckTMSOn8hS1--lOti30";
    private String customerToken = "j3bt0gHsHycDz5fMX-okEPK8MLNFY32PQELEVj4QYCyhf-H7";
    private String customerEmail = "cleeng@robertjesionek.com";

    private Cleeng api;

    private double sleepRatio = 1;

    @Before
    public void setUp() throws MalformedURLException, IOException {
        this.api = CleengFactory.createSandboxApi(publisherToken);
        this.customerToken = this.api.generateCustomerToken(this.customerEmail).result.token;
    }

    @After
    public void tearDown() {

        this.api = null;
    }

    @Test
    public void testGenerateCustomerToken() throws IOException {
        final TokenResponse response = this.api.generateCustomerToken(this.customerEmail);
        assertNotNull(response);
        assertNull(response.error);
        this.customerToken = response.result.token;
        assertNotNull(response.result.token);
    }

    @Test
    public void testGenerateCustomerTokenAsync() throws IOException, InterruptedException {
        final AsyncRequestCallback<TokenResponse> callback = new AsyncRequestCallback<TokenResponse>(TokenResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncTokenRequest(callback, this.customerEmail));
        final List<String> tokens = new ArrayList<String>();
        final int count = 10;
        for (int i = 0; i < count; i++) {
            requests.add(new AsyncTokenRequest(new AsyncRequestCallback<TokenResponse>(TokenResponse.class), this.customerEmail));
        }
        this.api.generateCustomerTokenAsync(requests);
        TimeUnit.MILLISECONDS.sleep(this.getSleepTime(requests.size()));
        for (int j = 0; j < requests.size(); j++) {
            tokens.add(((AsyncRequestCallback<TokenResponse>) requests.get(j).callback).getResponse().result.token);
        }
        assertEquals("Tokens array should match", 11, tokens.size());
    }

    @Test
    public void testCreateSubscriptionOffer() throws IOException {
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
        final OfferResponse response = this.api.createSubscriptionOffer( offerData );
        assertNotNull(response);
        assertNotNull(response.result.accessToTags);
        assertEquals("offer title should equal", offerData.title, response.result.title);
    }

    @Test
    public void updateSubscriptionOffer() throws IOException {
        final SubscriptionOfferData offerData = new SubscriptionOfferData(12.34,
            "week",
            "title updated",
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
        final OfferResponse response = this.api.updateSubscriptionOffer(offerData, "S222742070_PL");
        assertNotNull(response);
        assertEquals("offer title should equal", offerData.title, response.result.title);
    }

    @Test
    public void testCreateSubscriptionOfferAsync() throws IOException, InterruptedException {
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
        final SubscriptionOfferData offerData2 = new SubscriptionOfferData(12.34,
                "week",
                "title",
                "http://www.someurl.com/new",
                "description",
                null,
                0,
                9,
                Arrays.asList("Sport"),
                true,
                "whitelist",
                Arrays.asList("PL", "DE")
        );
        final AsyncRequestCallback<OfferResponse> callback = new AsyncRequestCallback<OfferResponse>(OfferResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(offerData, callback));
        requests.add(new AsyncRequest(offerData2, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        requests.add(new AsyncRequest(offerData2, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        requests.add(new AsyncRequest(offerData2, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        requests.add(new AsyncRequest(offerData2, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        requests.add(new AsyncRequest(offerData2, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        requests.add(new AsyncRequest(offerData2, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        requests.add(new AsyncRequest(offerData2, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        requests.add(new AsyncRequest(offerData2, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        requests.add(new AsyncRequest(offerData2, new AsyncRequestCallback<OfferResponse>(OfferResponse.class)));
        this.api.createSubscriptionOfferAsync(requests);
        TimeUnit.MILLISECONDS.sleep(this.getSleepTime(requests.size()));
        final OfferResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertEquals("Average rating should match", 4, response.result.averageRating);
    }

    @Test
    public void testUpdateSubscriptionOfferAsync() throws IOException, InterruptedException {
        final SubscriptionOfferData offerData = new SubscriptionOfferData(12.34,
            "week",
            "title updated",
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
        final AsyncRequestCallback<OfferResponse> callback = new AsyncRequestCallback<OfferResponse>(OfferResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncUpdateOfferRequest(offerData, callback, "S222742070_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<OfferResponse>(OfferResponse.class), "S222742070_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<OfferResponse>(OfferResponse.class), "S222742070_PL"));
        this.api.updateSubscriptionOfferAsync(requests);
        TimeUnit.MILLISECONDS.sleep(this.getSleepTime(requests.size()));
        final OfferResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertEquals("Average rating should match", offerData.title, response.result.title);
    }

    @Test
    public void testCreateSingleOffer() throws IOException {
        final SingleOfferData offerData = new SingleOfferData(12.34,
                "title",
                "http://www.someurl.com",
                "description",
                null,
                "7777",
                "778",
                "8787",
                Arrays.asList("Sport"),
                true,
                "whitelist",
                Arrays.asList("PL","DE")
        );
        final SingleOfferResponse response = this.api.createSingleOffer(offerData);
        assertNotNull(response);
        assertEquals("offer title should equal", offerData.title, response.result.title);
        assertEquals("videoId should match", offerData.videoId, response.result.videoId);
    }

    @Test
    public void testUpdateSingleOffer() throws IOException {
        final SingleOfferData offerData = new SingleOfferData(12.34,
            "title updated",
            "http://www.someurl.com",
            "description",
            null,
            "videoIdUpdated",
            "778",
            "8787",
            Arrays.asList("Sport"),
            true,
            "whitelist",
            Arrays.asList("PL","DE")
        );
        final SingleOfferResponse response = this.api.updateSingleOffer("A127679757_PL", offerData);
        assertNotNull(response);
        assertEquals("offer title should equal", offerData.title, response.result.title);
        assertEquals("videoId should match", offerData.videoId, response.result.videoId);
    }

    @Test
    public void testCreateSingleOfferAsync() throws IOException, InterruptedException {
        final SingleOfferData offerData = new SingleOfferData(12.34,
            "title",
            "http://www.someurl.com",
            "description",
            null,
            "7777",
            "778",
            "8787",
            Arrays.asList("Sport"),
            true,
            "whitelist",
            Arrays.asList("PL","DE")
        );
        final AsyncRequestCallback<SingleOfferResponse> callback = new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(offerData, callback));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class)));
        this.api.createSingleOfferAsync(requests);
        TimeUnit.MILLISECONDS.sleep(this.getSleepTime(requests.size()));
        final SingleOfferResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertEquals("Average rating should match", true, response.result.active);
    }

    @Test
    public void testUpdateSingleOfferAsync() throws IOException, InterruptedException {
        final SingleOfferData offerData = new SingleOfferData(12.34,
                "new title 2",
                "http://www.someurl.com",
                "description",
                null,
                "7777",
                "778",
                "8787",
                Arrays.asList("Sport"),
                true,
                "whitelist",
                Arrays.asList("PL","DE")
        );
        final AsyncRequestCallback<SingleOfferResponse> callback = new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncUpdateOfferRequest(offerData, callback, "A127679757_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class), "A127679757_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class), "A127679757_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class), "A127679757_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class), "A127679757_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class), "A127679757_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class), "A127679757_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class), "A127679757_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class), "A127679757_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class), "A127679757_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<SingleOfferResponse>(SingleOfferResponse.class), "A127679757_PL"));
        this.api.updateSingleOfferAsync(requests);
        TimeUnit.MILLISECONDS.sleep(this.getSleepTime(requests.size()));
        final SingleOfferResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertEquals("Average rating should match", offerData.title, response.result.title);
    }

    @Test
    public void testCreateEventOffer() throws IOException {
        final EventOfferDataRequest offerData = new EventOfferDataRequest(12.34,
            "GBP",
            "titleval",
            "http://www.someurl.com",
            "desc",
            "9A",
            "90",
            "http://www.someurl.com",
            1999999990,
            1999999999,
            "America/New_York",
            null,
            "7777",
            "2",
            "teaser",
            true,
            Arrays.asList("Sport"),
            true,
            "whitelist",
            Arrays.asList("PL", "DE")
        );
        final EventOfferResponse response = this.api.createEventOffer(offerData);
        assertNotNull(response);
        assertEquals("offer title should equal", offerData.title, response.result.title);
        assertEquals("teaser should match", offerData.teaser, response.result.teaser);
    }

    @Test
    public void testUpdateEventOffer() throws IOException {
        final EventOfferDataRequest offerData = new EventOfferDataRequest(12.34,
            "GBP",
            "titleval updated",
            "http://www.someurl.com",
            "desc",
            "9A",
            "90",
            "http://www.someurl.com",
            1999999990,
            1999999999,
            "America/New_York",
            null,
            "7777",
            "2",
            "teaser updated",
            true,
            Arrays.asList("Sport"),
            true,
            "whitelist",
            Arrays.asList("PL", "DE")
        );
        final EventOfferResponse response = this.api.updateEventOffer(offerData, "E575167459_PL");
        assertNotNull(response);
        assertEquals("offer title should equal", offerData.title, response.result.title);
        assertEquals("teaser should match", offerData.teaser, response.result.teaser);
    }

    @Test
    public void testCreateEventOfferAsync() throws IOException, InterruptedException {
        final EventOfferDataRequest offerData = new EventOfferDataRequest(12.34,
                "GBP",
                "titleval",
                "http://www.someurl.com",
                "desc",
                "9A",
                "90",
                "http://www.someurl.com",
                1999999990,
                1999999999,
                "America/New_York",
                null,
                "7777",
                "2",
                "teaser",
                true,
                Arrays.asList("Sport"),
                true,
                "whitelist",
                Arrays.asList("PL", "DE")
        );
        final AsyncRequestCallback<EventOfferResponse> callback = new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(offerData, callback));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class)));
        this.api.createEventOfferAsync(requests);
        TimeUnit.MILLISECONDS.sleep(this.getSleepTime(requests.size()));
        final EventOfferResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertEquals("Active should match", true, response.result.active);
    }

    @Test
    public void testUpdateEventOfferAsync() throws IOException, InterruptedException {
        final EventOfferDataRequest offerData = new EventOfferDataRequest(12.34,
                "GBP",
                "titleval updated",
                "http://www.someurl.com",
                "desc",
                "9A",
                "90",
                "http://www.someurl.com",
                1999999990,
                1999999999,
                "America/New_York",
                null,
                "7777",
                "2",
                "teaser",
                true,
                Arrays.asList("Sport"),
                true,
                "whitelist",
                Arrays.asList("PL", "DE")
        );
        final AsyncRequestCallback<EventOfferResponse> callback = new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncUpdateOfferRequest(offerData, callback, "E575167459_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class), "E575167459_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class), "E575167459_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class), "E575167459_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class), "E575167459_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class), "E575167459_PL"));
        this.api.updateEventOfferAsync(requests);
        TimeUnit.MILLISECONDS.sleep(this.getSleepTime(requests.size()));
        final EventOfferResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertEquals("Active should match", offerData.title, response.result.title);
    }

    @Test
    public void testCreateRentalOffer() throws IOException {
        final RentalOfferData offerData = new RentalOfferData(12.34,
            "title",
            48,
            "http://www.someurl.com",
            "description",
            null,
            "7777",
            "2",
            "some text",
            Arrays.asList("Sport", "Entertainment")
        );
        final RentalOfferResponse response = this.api.createRentalOffer(offerData);
        assertNotNull(response);
        assertEquals("offer title should equal", offerData.title, response.result.title);
        assertEquals("period should match", offerData.period, response.result.period);
    }

    @Test
    public void testCreateRentalOfferAsync() throws IOException, InterruptedException {
        final RentalOfferData offerData = new RentalOfferData(12.34,
                "title",
                48,
                "http://www.someurl.com",
                "description",
                null,
                "7777",
                "2",
                "some text",
                Arrays.asList("Sport", "Entertainment")
        );
        final AsyncRequestCallback<RentalOfferResponse> callback = new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(offerData, callback));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class)));
        this.api.createRentalOfferAsync(requests);
        TimeUnit.MILLISECONDS.sleep(this.getSleepTime(requests.size()));
        final RentalOfferResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertEquals("Active should match", true, response.result.active);
    }

    @Test
    public void testUpdateRentalOffer() throws IOException {
        final RentalOfferData offerData = new RentalOfferData(12.34,
            "title updated",
            24,
            "http://www.someurl.com",
            "description updated",
            null,
            "7777",
            "3",
            "some text 2",
            Arrays.asList("Sport", "Entertainment")
        );
        final RentalOfferResponse response = this.api.updateRentalOffer(offerData, "R802832039_PL");
        assertNotNull(response);
        assertEquals("offer title should equal", offerData.title, response.result.title);
        assertEquals("period should match", offerData.period, response.result.period);
    }

    @Test
    public void testUpdateRentalOfferAsync() throws IOException, InterruptedException {
        final RentalOfferData offerData = new RentalOfferData(12.34,
            "title updated",
            24,
            "http://www.someurl.com",
            "description updated",
            null,
            "7777",
            "2",
            "some text",
            Arrays.asList("Sport", "Entertainment")
        );
        final AsyncRequestCallback<RentalOfferResponse> callback = new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncUpdateOfferRequest(offerData, callback, "R802832039_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class), "R802832039_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class), "R802832039_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class), "R802832039_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class), "R802832039_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class), "R802832039_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class), "R802832039_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class), "R802832039_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class), "R802832039_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class), "R802832039_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class), "R802832039_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class), "R802832039_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class), "R802832039_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class), "R802832039_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class), "R802832039_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<RentalOfferResponse>(RentalOfferResponse.class), "R802832039_PL"));
        this.api.updateRentalOfferAsync(requests);
        TimeUnit.MILLISECONDS.sleep(this.getSleepTime(requests.size()));
        final RentalOfferResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertEquals("Active should match", offerData.title, response.result.title);
    }

    @Test
    public void testCreatePassOffer() throws IOException {
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
        final PassOfferResponse response = this.api.createPassOffer(offerData);
        assertNotNull(response);
        assertEquals("offer title should equal", offerData.title, response.result.title);
        assertEquals("period should match", offerData.expiresAt, response.result.expiresAt);
    }

    @Test
    public void testUpdatePassOffer() throws IOException {
        final PassOfferData offerData = new PassOfferData(12.34,
                null,
                1900000001,
                "title",
                "http://www.someurl.com/new",
                null,
                "description",
                Arrays.asList("Sport"),
                true,
                "whitelist",
                Arrays.asList("PL","DE")
        );
        final OfferResponse response = this.api.updatePassOffer(offerData, "P808240899_PL");
        assertNotNull(response);
        assertEquals("offer title should equal", offerData.url, response.result.url);
        assertEquals("period should match", offerData.expiresAt, response.result.expiresAt);
    }

    @Test
    public void testCreatePassOfferAsync() throws IOException, InterruptedException {

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
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(offerData, callback));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class)));
        this.api.createPassOfferAsync(requests);
        TimeUnit.MILLISECONDS.sleep(this.getSleepTime(requests.size()));
        final PassOfferResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertEquals("Active should match", true, response.result.active);
    }

    @Test
    public void testUpdatePassOfferAsync() throws IOException, InterruptedException {
        final PassOfferData offerData = new PassOfferData(12.34,
                null,
                1900000000,
                "title 2",
                "http://www.someurl.com",
                null,
                "description",
                Arrays.asList("Sport"),
                true,
                "whitelist",
                Arrays.asList("PL","DE")
        );
        final AsyncRequestCallback<PassOfferResponse> callback = new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncUpdateOfferRequest(offerData, callback, "P808240899_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class), "P808240899_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class), "P808240899_PL"));
        requests.add(new AsyncUpdateOfferRequest(offerData, new AsyncRequestCallback<PassOfferResponse>(PassOfferResponse.class), "P808240899_PL"));
        this.api.updatePassOfferAsync(requests);
        TimeUnit.MILLISECONDS.sleep(this.getSleepTime(requests.size()));
        final PassOfferResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertEquals("Active should match", offerData.title, response.result.title);
    }

    @Test
    public void testCreatePassOfferError() throws IOException {
        final PassOfferData offerData = new PassOfferData(12.34,
                "month",
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
        final PassOfferResponse response = this.api.createPassOffer(offerData);
        assertNotNull(response);
        assertNull(response.result);
        assertNotNull(response.error);
        assertEquals("error code should match ", 8, response.error.code);
    }

    @Test
    public void testListSubscriptionOffers() throws IOException {
        final Criteria criteria = new Criteria(true);
        final ListSubscriptionOffersResponse response = this.api.listSubscriptionOffers(criteria, 0, 10);
        assertNotNull(response);
        assertEquals("list length should match", 10, response.result.items.size());
    }

    @Test
    public void testListSubscriptionOffersAsync() throws IOException, InterruptedException {
        final AsyncRequestCallback<ListSubscriptionOffersResponse> callback = new AsyncRequestCallback<ListSubscriptionOffersResponse>(ListSubscriptionOffersResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncListRequest(new Criteria(true), callback, 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListSubscriptionOffersResponse>(ListSubscriptionOffersResponse.class), 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListSubscriptionOffersResponse>(ListSubscriptionOffersResponse.class), 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListSubscriptionOffersResponse>(ListSubscriptionOffersResponse.class), 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListSubscriptionOffersResponse>(ListSubscriptionOffersResponse.class), 0, 10));
        this.api.listSubscriptionOffersAsync(requests);
        TimeUnit.MILLISECONDS.sleep(this.getSleepTime(requests.size()));
        final ListSubscriptionOffersResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertTrue("List should contain items", response.result.items.size() > 0);
    }

    @Test
    public void testListSingleOffers() throws IOException {
        final Criteria criteria = new Criteria(true);
        final ListSingleOffersResponse response = this.api.listSingleOffers(criteria, 0, 10);
        assertNotNull(response);
        assertEquals("list length should match", 10, response.result.items.size());
    }

    @Test
    public void testListSingleOffersAsync() throws IOException, InterruptedException {
        final AsyncRequestCallback<ListSingleOffersResponse> callback = new AsyncRequestCallback<ListSingleOffersResponse>(ListSingleOffersResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncListRequest(new Criteria(true), callback, 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListSingleOffersResponse>(ListSingleOffersResponse.class), 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListSingleOffersResponse>(ListSingleOffersResponse.class), 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListSingleOffersResponse>(ListSingleOffersResponse.class), 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListSingleOffersResponse>(ListSingleOffersResponse.class), 0, 10));
        this.api.listSingleOffersAsync(requests);
        TimeUnit.MILLISECONDS.sleep(this.getSleepTime(requests.size()));
        final ListSingleOffersResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertNotNull(response.result);
        assertTrue("List should contain items", response.result.items.size() > 0);
    }

    @Test
    @Ignore
    public void testListVodOffers() throws IOException {
        final Criteria criteria = new Criteria(true);
        final ListVodOffersResponse response = this.api.listVodOffers(criteria, 0, 10);
        assertNotNull(response);
        assertNotNull(response.result);
        assertEquals("list length should match", 10, response.result.items.size());
    }

    @Test
    @Ignore
    public void testListVodOffersAsync() throws IOException, InterruptedException {
        final AsyncRequestCallback<ListVodOffersResponse> callback = new AsyncRequestCallback<ListVodOffersResponse>(ListVodOffersResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncListRequest(new Criteria(true), callback, 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListVodOffersResponse>(ListVodOffersResponse.class), 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListVodOffersResponse>(ListVodOffersResponse.class), 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListVodOffersResponse>(ListVodOffersResponse.class), 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListVodOffersResponse>(ListVodOffersResponse.class), 0, 10));
        this.api.listVodOffersAsync(requests);
        TimeUnit.MILLISECONDS.sleep(this.getSleepTime(requests.size()));
        final ListVodOffersResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertNotNull(response.result);
        assertTrue("List should contain items", response.result.items.size() > 0);
    }

    @Test
    public void testListPassOffers() throws IOException {
        final Criteria criteria = new Criteria(true);
        final ListPassOffersResponse response = this.api.listPassOffers(criteria, 0, 10);
        assertNotNull(response);
        assertEquals("list length should match", 10, response.result.items.size());
    }

    @Test
    public void testListPassOffersAsync() throws IOException, InterruptedException {
        final AsyncRequestCallback<ListPassOffersResponse> callback = new AsyncRequestCallback<ListPassOffersResponse>(ListPassOffersResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncListRequest(new Criteria(true), callback, 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListPassOffersResponse>(ListPassOffersResponse.class), 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListPassOffersResponse>(ListPassOffersResponse.class), 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListPassOffersResponse>(ListPassOffersResponse.class), 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListPassOffersResponse>(ListPassOffersResponse.class), 0, 10));
        this.api.listPassOffersAsync(requests);
        TimeUnit.MILLISECONDS.sleep(this.getSleepTime(requests.size()));
        final ListPassOffersResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertTrue("List should contain items", response.result.items.size() > 0);
    }

    @Test
    public void testPrepareRemoteAuth() throws IOException {
        final CustomerData customerData = new CustomerData(this.customerEmail, "en_US", "GBP", "PL");
        final FlowDescription flowDescription = new FlowDescription("8", "http://www.someurl.com");
        final PrepareRemoteAuthResponse response = this.api.prepareRemoteAuth(customerData, flowDescription);
        assertNotNull(response);
        assertTrue(response.result.url.length() > 0);
    }

    @Test
    public void testPrepareRemoteAuthAsync() throws IOException, InterruptedException {
        final CustomerData customerData = new CustomerData(this.customerEmail, "en_US", "GBP", "PL");
        final FlowDescription flowDescription = new FlowDescription("8", "http://www.someurl.com");
        final AsyncRequestCallback<PrepareRemoteAuthResponse> callback = new AsyncRequestCallback<PrepareRemoteAuthResponse>(PrepareRemoteAuthResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncPrepareRemoteAuthRequest(customerData, flowDescription, callback));
        this.api.prepareRemoteAuthAsync(requests);
        TimeUnit.MILLISECONDS.sleep(this.getSleepTime(requests.size()));
        final PrepareRemoteAuthResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertTrue("List should contain items", response.result.url.length() > 0);
    }

    @Test
    @Ignore
    public void testUpdateCustomerPassword() throws IOException {
        //Provide valid reset token
        final String resetPasswordToken = "e50f9415dd9059e8f8b7a4443c635ca763c56256";
        final String newPassword = "newpass2001";
        final BooleanResponse response = this.api.updateCustomerPassword(this.customerEmail, resetPasswordToken, newPassword);
        assertNotNull(response);
        assertNull(response.error);
        assertTrue(response.result.success);
    }

    @Test
    @Ignore
    public void testUpdateCustomerPasswordAsync() throws IOException, InterruptedException {
        //Provide valid reset token
        final String resetPasswordToken = "e50f9415dd9059e8f8b7a4443c635ca763c56256";
        final String newPassword = "newpass2002";
        final AsyncRequestCallback<BooleanResponse> callback = new AsyncRequestCallback<BooleanResponse>(BooleanResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(new ResetPasswordParams(this.customerEmail, resetPasswordToken, newPassword), callback));
        this.api.updateCustomerPasswordAsync(requests);
        TimeUnit.MILLISECONDS.sleep(getSleepTime(requests.size()));
        final BooleanResponse response = callback.getResponse();
        assertTrue(response.result.success);
    }

    @Test
    public void testUpdateCustomerEmail() throws IOException, InterruptedException {
        final BooleanResponse syncResponse = this.api.updateCustomerEmail(this.customerEmail, "cleeng2@robertjesionek.com");
        assertNotNull(syncResponse);
        assertNull(syncResponse.error);
        assertTrue(syncResponse.result.success);
        final AsyncRequestCallback<BooleanResponse> callback = new AsyncRequestCallback<BooleanResponse>(BooleanResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(new UpdateCustomerEmailParams("cleeng2@robertjesionek.com", this.customerEmail), callback));
        this.api.updateCustomerEmailAsync(requests);
        TimeUnit.SECONDS.sleep(5);
        final BooleanResponse response = callback.getResponse();
        assertTrue(response.result.success);
    }

    @Test
    public void testGenerateCheckoutUrlForSubscription() throws IOException {
        final UrlResponse response = this.api.generateCheckoutUrl(this.customerEmail, new FlowDescription("S587628980_PL", "http://www.someurl.com"));
        assertNotNull("Response object should not be null", response);
        assertTrue("Response url should have lenght > 0", response.result.url.length() > 0);
    }

    @Test
    public void testUpdateCustomerSubscription() throws IOException {
        String offerId = "S587628980_PL";
        UpdateCustomerSubscriptionOfferData offerData = new UpdateCustomerSubscriptionOfferData("cancelled", "1717356800");
        final UpdateCustomerSubscriptionResponse response = this.api.updateCustomerSubscription(offerId, customerEmail, offerData);
        Assert.assertNotNull(response);
        Assert.assertEquals("Response status should be cancelled", "cancelled", response.result.status);
    }

    @Test
    public void testUpdateCustomerSubscriptionAsync() throws IOException, InterruptedException {
        final AsyncRequestCallback<UpdateCustomerSubscriptionResponse> callback = new AsyncRequestCallback<UpdateCustomerSubscriptionResponse>(UpdateCustomerSubscriptionResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(new UpdateCustomerSubscriptionParams(this.customerEmail,"S587628980_PL", new UpdateCustomerSubscriptionOfferData("cancelled", "1717356800")), callback));
        this.api.updateCustomerSubscriptionAsync(requests);
        TimeUnit.SECONDS.sleep(5);
        final UpdateCustomerSubscriptionResponse response = callback.getResponse();
        Assert.assertNotNull(response);
        Assert.assertEquals("Response status should be cancelled", "cancelled", response.result.status);
    }

    @Test
    public void testRequestPasswordReset() throws IOException {
        final BooleanResponse response = this.api.requestPasswordReset(this.customerEmail);
        assertNotNull(response);
        assertNull(response.error);
        assertTrue(response.result.success);
    }

    @Test
    public void testRequestPasswordResetAsync() throws IOException, InterruptedException {
        final AsyncRequestCallback<BooleanResponse> callback = new AsyncRequestCallback<BooleanResponse>(BooleanResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncTokenRequest(callback, this.customerEmail));
        this.api.requestPasswordResetAsync(requests);
        TimeUnit.MILLISECONDS.sleep(2000);
        final BooleanResponse response = callback.getResponse();
        assertTrue(response.result.success);
    }

    @Test
    public void testGenerateCustomerTokenFromPassword() throws IOException {
        final TokenResponse response = this.api.generateCustomerTokenFromPassword("mycleengpassword", this.customerEmail);
        assertNotNull(response);
        assertNull(response.error);
        assertNotNull(response.result.token);
    }

    @Test
    public void testGenerateCustomerTokenFromPasswordAsync() throws IOException, InterruptedException {
        final AsyncRequestCallback<TokenResponse> callback = new AsyncRequestCallback<TokenResponse>(TokenResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncGenerateCustomerTokenFromPasswordRequest(this.publisherToken, "mycleengpassword", this.customerEmail, callback));
        requests.add(new AsyncGenerateCustomerTokenFromPasswordRequest(this.publisherToken, "mycleengpassword", this.customerEmail, new AsyncRequestCallback<TokenResponse>(TokenResponse.class)));
        requests.add(new AsyncGenerateCustomerTokenFromPasswordRequest(this.publisherToken, "mycleengpassword", this.customerEmail, new AsyncRequestCallback<TokenResponse>(TokenResponse.class)));
        requests.add(new AsyncGenerateCustomerTokenFromPasswordRequest(this.publisherToken, "mycleengpassword", this.customerEmail, new AsyncRequestCallback<TokenResponse>(TokenResponse.class)));
        requests.add(new AsyncGenerateCustomerTokenFromPasswordRequest(this.publisherToken, "mycleengpassword", this.customerEmail, new AsyncRequestCallback<TokenResponse>(TokenResponse.class)));
        this.api.generateCustomerTokenFromPasswordAsync(requests);
        TimeUnit.MILLISECONDS.sleep(getSleepTime(requests.size()));
        final TokenResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertTrue("Token should be present in response object", response.result.token.length() > 0);
    }

    @Test
    public void testGenerateCustomerTokenFromFacebook() throws IOException {
        final TokenResponse response = this.api.generateCustomerTokenFromFacebook("mycleengussr");
        assertNotNull(response);
        assertNull(response.error);
        assertNotNull(response.result.token);
    }

    @Test
    public void testGenerateCustomerTokenFromFacebookAsync() throws IOException, InterruptedException {
        final AsyncRequestCallback<TokenResponse> callback = new AsyncRequestCallback<TokenResponse>(TokenResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncTokenRequest(callback, "mycleengussr"));
        requests.add(new AsyncTokenRequest(new AsyncRequestCallback<TokenResponse>(TokenResponse.class), "mycleengussr"));
        requests.add(new AsyncTokenRequest(new AsyncRequestCallback<TokenResponse>(TokenResponse.class), "mycleengussr"));
        requests.add(new AsyncTokenRequest(new AsyncRequestCallback<TokenResponse>(TokenResponse.class), "mycleengussr"));
        requests.add(new AsyncTokenRequest(new AsyncRequestCallback<TokenResponse>(TokenResponse.class), "mycleengussr"));
        this.api.generateCustomerTokenFromFacebookAsync(requests);
        TimeUnit.MILLISECONDS.sleep(getSleepTime(requests.size()));
        final TokenResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertTrue("Token should be present in response object", response.result.token.length() > 0);
    }

    @Test
    public void testGetAccessStatus() throws IOException {
        final GetAccessStatusResponse response = this.api.getAccessStatus(this.customerToken, "A334745341_PL", "78.129.213.71");
        assertNotNull(response.result);
        assertEquals("Access granted should match", true, response.result.accessGranted);
        assertEquals("ExpiresAt should match", 1717356800, response.result.expiresAt);
        assertEquals("PurchasedDirectly should match", false, response.result.purchasedDirectly);
    }

    @Test
    public void testGetAccessStatusAsync() throws IOException, InterruptedException {
        final AsyncRequestCallback<GetAccessStatusResponse> callback = new AsyncRequestCallback<GetAccessStatusResponse>(GetAccessStatusResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncGetAccessStatusRequest(this.customerToken, "A334745341_PL", "78.129.213.71", callback));
        requests.add(new AsyncGetAccessStatusRequest(this.customerToken, "A334745341_PL", "78.129.213.71", new AsyncRequestCallback<GetAccessStatusResponse>(GetAccessStatusResponse.class)));
        this.api.getAccessStatusAsync(requests);
        TimeUnit.MILLISECONDS.sleep(getSleepTime(requests.size()));
        final GetAccessStatusResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertTrue("Access should be granted", response.result.accessGranted);
    }

    @Test
    public void testGetAccessibleTags() throws IOException {
        final GetAccessibleTagsResponse response = this.api.getAccessibleTags(this.publisherToken, this.customerToken);
        assertNotNull(response.result);
        assertNotNull(response.result.tags);
    }

    @Test
    public void testGetAccessibleTagsAsync() throws IOException, InterruptedException {
        final AsyncRequestCallback<GetAccessibleTagsResponse> callback = new AsyncRequestCallback<GetAccessibleTagsResponse>(GetAccessibleTagsResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncGetAccessibleTagsRequest(this.publisherToken, this.customerToken, callback));
        requests.add(new AsyncGetAccessibleTagsRequest(this.publisherToken, this.customerToken, new AsyncRequestCallback<GetAccessibleTagsResponse>(GetAccessibleTagsResponse.class)));
        requests.add(new AsyncGetAccessibleTagsRequest(this.publisherToken, this.customerToken, new AsyncRequestCallback<GetAccessibleTagsResponse>(GetAccessibleTagsResponse.class)));
        this.api.getAccessibleTagsAsync(requests);
        TimeUnit.MILLISECONDS.sleep(getSleepTime(requests.size()));
        final GetAccessibleTagsResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertTrue("List should contain items", response.result.tags.size() > 0);
    }

    @Test
    public void testGetCustomer() throws IOException {
        final GetCustomerResponse response = this.api.getCustomer(this.customerToken);
        assertNotNull(response.result);
    }

    @Test
    public void testGetCustomerAsync() throws IOException, InterruptedException {
        final AsyncRequestCallback<GetCustomerResponse> callback = new AsyncRequestCallback<GetCustomerResponse>(GetCustomerResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(this.customerToken, callback));
        requests.add(new AsyncRequest(this.customerToken, new AsyncRequestCallback<GetCustomerResponse>(GetCustomerResponse.class)));
        requests.add(new AsyncRequest(this.customerToken, new AsyncRequestCallback<GetCustomerResponse>(GetCustomerResponse.class)));
        this.api.getCustomerAsync(requests);
        long sleepTime = getSleepTime(requests.size());
        TimeUnit.MILLISECONDS.sleep(sleepTime);
        final GetCustomerResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertEquals("List should contain items", "PL", response.result.country);
    }

    @Test
    public void testCreateVodOffer() throws IOException {
        final VodOfferData offerData = new VodOfferData(12.34,
            "some title",
            "http://www.someurl.com",
            "description",
            null,
            "iuyiu",
            "playerC",
            "playerCodeH",
            "7",
            "7",
            "hd",
            null,
            Arrays.asList("Sport"),
            Arrays.asList("PL", "DE"),
            false,
            "whitelist",
            "http://www.someurl.com/image.png"
        );
        final VodOfferResponse response = this.api.createVodOffer(offerData);
        assertNotNull(response);
        assertEquals("offer title should equal", offerData.title, response.result.vod.title);
    }

    @Test
    public void testCreateVodOfferAsync() throws IOException, InterruptedException {
        final VodOfferData offerData = new VodOfferData(12.34,
                "some title",
                "http://www.someurl.com",
                "description",
                null,
                "vidoeId",
                "playerC",
                "playerCodeH",
                "7",
                "7",
                "hd",
                null,
                Arrays.asList("Sport"),
                Arrays.asList("PL", "DE"),
                false,
                "whitelist",
                "http://www.someurl.com/image.png"
        );
        final AsyncRequestCallback<VodOfferResponse> callback = new AsyncRequestCallback<VodOfferResponse>(VodOfferResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncCreateVodOfferRequest(this.publisherToken, offerData, callback));
        requests.add(new AsyncCreateVodOfferRequest(this.publisherToken, offerData, new AsyncRequestCallback<VodOfferResponse>(VodOfferResponse.class)));
        requests.add(new AsyncCreateVodOfferRequest(this.publisherToken, offerData, new AsyncRequestCallback<VodOfferResponse>(VodOfferResponse.class)));
        this.api.createVodOfferAsync(requests);
        TimeUnit.MILLISECONDS.sleep(getSleepTime(requests.size()));
        final VodOfferResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertEquals("List should contain items", offerData.title, response.result.vod.title);
    }

    @Test
    public void testGetVodOffer() throws IOException {
        final VodOfferResponse response = this.api.getVodOffer("R262528011_PL");
        assertNotNull(response);
        assertEquals("offer title should equal", "hd", response.result.vod.videoQuality);
    }

    @Test
    public void testGetVodOfferAsync() throws IOException, InterruptedException {
        final AsyncRequestCallback<VodOfferResponse> callback = new AsyncRequestCallback<VodOfferResponse>(VodOfferResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncGetVodOfferRequest(this.publisherToken, "R262528011_PL", callback));
        requests.add(new AsyncGetVodOfferRequest(this.publisherToken, "R262528011_PL", new AsyncRequestCallback<VodOfferResponse>(VodOfferResponse.class)));
        requests.add(new AsyncGetVodOfferRequest(this.publisherToken, "R262528011_PL", new AsyncRequestCallback<VodOfferResponse>(VodOfferResponse.class)));
        this.api.getVodOfferAsync(requests);
        TimeUnit.MILLISECONDS.sleep(getSleepTime(requests.size()));
        final VodOfferResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertEquals("List should contain items", "hd", response.result.vod.videoQuality);
    }

    @Test
    public void testUpdateVodOffer() throws IOException {
        final VodOfferData offerData = new VodOfferData(12.34,
            "some updated title",
            "http://www.someurl.com",
            "description",
            null,
            "videoId",
            "playerCode",
            "playerCodeHead",
            "7",
            "7",
            "hd",
            null,
            Arrays.asList("Sport"),
            Arrays.asList("PL", "DE"),
            false,
            "whitelist",
            "http://www.someurl.com/image.png"
        );
        final VodOfferResponse response = this.api.updateVodOffer("R262528011_PL", offerData);
        assertNotNull(response);
        assertEquals("offer title should equal", offerData.title, response.result.vod.title);
    }

    @Test
    public void testUpdateVodOfferAsync() throws IOException, InterruptedException {
        final VodOfferData offerData = new VodOfferData(12.34,
            "some title",
            "http://www.someurl.com",
            "description",
            null,
            "videoIdUpdated",
            "playerC",
            "playerCodeH",
            "7",
            "7",
            "hd",
            null,
            Arrays.asList("Sport"),
            Arrays.asList("PL", "DE"),
            false,
            "whitelist",
            "http://www.someurl.com/image.png"
        );
        final AsyncRequestCallback<VodOfferResponse> callback = new AsyncRequestCallback<VodOfferResponse>(VodOfferResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncUpdateVodOfferRequest(this.publisherToken, offerData, callback, "R262528011_PL"));
        requests.add(new AsyncUpdateVodOfferRequest(this.publisherToken, offerData, new AsyncRequestCallback<VodOfferResponse>(VodOfferResponse.class), "R262528011_PL"));
        requests.add(new AsyncUpdateVodOfferRequest(this.publisherToken, offerData, new AsyncRequestCallback<VodOfferResponse>(VodOfferResponse.class), "R262528011_PL"));
        this.api.updateVodOfferAsync(requests);
        TimeUnit.MILLISECONDS.sleep(getSleepTime(requests.size()));
        final VodOfferResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertEquals("List should contain items", offerData.videoId, response.result.vod.videoId);
    }

    @Test
    public void testGenerateCheckoutUrl() throws IOException {
        final UrlResponse response = this.api.generateCheckoutUrl(this.customerEmail, new FlowDescription("A962575346_PL", "http://www.someurl.com"));
        assertNotNull("Response object should not be null", response);
        assertTrue("Response url should have lenght > 0", response.result.url.length() > 0);
    }

    @Test
    public void testGenerateCheckoutUrlAsync() throws IOException, InterruptedException {
        final AsyncRequestCallback<UrlResponse> callback = new AsyncRequestCallback<UrlResponse>(UrlResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncGenerateCheckoutUrlRequest(this.publisherToken, this.customerEmail, new FlowDescription("A962575346_PL", "http://www.someurl.com"), callback));
        requests.add(new AsyncGenerateCheckoutUrlRequest(this.publisherToken, this.customerEmail, new FlowDescription("A962575346_PL", "http://www.someurl.com"), new AsyncRequestCallback<UrlResponse>(UrlResponse.class)));
        requests.add(new AsyncGenerateCheckoutUrlRequest(this.publisherToken, this.customerEmail, new FlowDescription("A962575346_PL", "http://www.someurl.com"), new AsyncRequestCallback<UrlResponse>(UrlResponse.class)));
        this.api.generateCheckoutUrlAsync(requests);
        TimeUnit.MILLISECONDS.sleep(getSleepTime(requests.size()));
        final UrlResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertTrue("Response url should have lenght > 0", response.result.url.length() > 0);
    }

    @Test
    public void testRegisterCustomer() throws IOException {
        final UUID uuid = UUID.randomUUID();
        final CustomerData customerData = new CustomerData(uuid.toString() + "@domain.com", "en_US", "GBP", "PL", "xxxxxxxxxxxxx");
        final TokenResponse response = this.api.registerCustomer(customerData);
        this.customerToken = response.result.token;
        assertNotNull(response);
        assertTrue(response.result.token.length() > 0);
    }

    @Test
    @Ignore
    public void testRegisterMyCustomer() throws IOException {
        final CustomerData customerData = new CustomerData("cleeng@robertjesionek.com", "en_US", "GBP", "PL", "mycleengpassword", "mycleengussr2");
        final TokenResponse response = this.api.registerCustomer(customerData);
        assertNotNull(response);
        //Token dASxiQ2wxjQ_bDZ5E5xndlPROR9P8AZuZ1DLexVNHAIEpePL
        assertTrue(response.result.token.length() > 0);
    }

    @Test
    public void testRegisterCustomerAsync() throws IOException, InterruptedException {
        final UUID uuid1 = UUID.randomUUID();
        final CustomerData input1 = new CustomerData(uuid1.toString() + "@domain.com", "en_US", "GBP", "PL", "xxxxxxxxxxxxx");
        final UUID uuid2 = UUID.randomUUID();
        final CustomerData input2 = new CustomerData(uuid2.toString() + "@domain.com", "en_US", "GBP", "PL", "xxxxxxxxxxxxx");
        final UUID uuid3 = UUID.randomUUID();
        final CustomerData input3 = new CustomerData(uuid3.toString() + "@domain.com", "en_US", "GBP", "PL", "xxxxxxxxxxxxx");
        final AsyncRequestCallback<TokenResponse> callback = new AsyncRequestCallback<TokenResponse>(TokenResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(input1, callback));
        requests.add(new AsyncRequest(input2, new AsyncRequestCallback<TokenResponse>(TokenResponse.class)));
        requests.add(new AsyncRequest(input3, new AsyncRequestCallback<TokenResponse>(TokenResponse.class)));
        this.api.registerCustomerAsync(requests);
        TimeUnit.MILLISECONDS.sleep(getSleepTime(requests.size()));
        final TokenResponse response = callback.getResponse();
        assertNotNull("Response object should not be null", response);
        assertTrue("Response token should have lenght > 0", response.result.token.length() > 0);
    }

    @Test
    public void testGenerateMyAccountUrl() throws IOException {
        final List<String> modules = new ArrayList<String>();
        final UrlResponse response = this.api.generateMyAccountUrl(this.customerEmail, modules);
        assertNotNull(response);
        assertTrue(response.result.url.length() > 0);
    }

    @Test
    public void testGenerateMyAccountUrlAsync() throws IOException, InterruptedException {
        final List<String> modules = new ArrayList<String>();
        final GenerateMyAccountUrlParams input = new GenerateMyAccountUrlParams(this.customerEmail, modules);
        final AsyncRequestCallback<UrlResponse> callback = new AsyncRequestCallback<UrlResponse>(UrlResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(input, callback));
        this.api.generateMyAccountUrlAsync(requests);
        TimeUnit.MILLISECONDS.sleep(getSleepTime(requests.size()));
        final UrlResponse response = callback.getResponse();
        assertNotNull(response);
        assertTrue(response.result.url.length() > 0);
    }

    @Test
    public void testListPaymentDetails() throws IOException {
        final PaymentDetailsResponse response = this.api.listPaymentDetails(this.customerEmail);
        assertNotNull(response);
        assertEquals("Result should be an array of size 1", 1, response.result.size());
        /*
        assertEquals("Result should be an array of size 1", 1, response.result.size());
        assertEquals("paymentDetailsId should match", "593681774", response.result.get(0).paymentDetailsId);
        assertEquals("paymentGateway should match", "adyen", response.result.get(0).paymentGateway);
        assertEquals("paymentMethod should match", "paypal", response.result.get(0).paymentMethod);
        assertEquals("cardExpirationDate should match", "01/50", response.result.get(0).cardExpirationDate);
        assertEquals("cardLastFourDigits should match", "J2FZ66VXPN", response.result.get(0).cardLastFourDigits);
        */
    }

    @Test
    public void testListPaymentDetailsAsync() throws IOException, InterruptedException {
        final PaymentDetailsParams input = new PaymentDetailsParams(this.customerEmail);
        final AsyncRequestCallback<PaymentDetailsResponse> callback = new AsyncRequestCallback<PaymentDetailsResponse>(PaymentDetailsResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(input, callback));
        this.api.listPaymentDetailsAsync(requests);
        TimeUnit.SECONDS.sleep(5);
        final PaymentDetailsResponse response = callback.getResponse();
        assertNotNull(response);
        assertEquals("Result should be an array of size 1", 1, response.result.size());
        /*
        assertEquals("Result should be an array of size 1", 1, response.result.size());
        assertEquals("paymentDetailsId should match", "593681774", response.result.get(0).paymentDetailsId);
        assertEquals("paymentGateway should match", "adyen", response.result.get(0).paymentGateway);
        assertEquals("paymentMethod should match", "paypal", response.result.get(0).paymentMethod);
        assertEquals("cardExpirationDate should match", "01/50", response.result.get(0).cardExpirationDate);
        assertEquals("cardLastFourDigits should match", "J2FZ66VXPN", response.result.get(0).cardLastFourDigits);
        */
    }

    @Test
    public void testListCustomerSubscriptions() throws IOException {
        final ListCustomerSubscriptionsResponse response = this.api.listCustomerSubscriptions(this.customerEmail, 0, 20);
        assertNotNull(response);
        assertNull(response.error);
    }

    @Test
    public void testListCustomerSubscriptionsAsync() throws IOException, InterruptedException {
        final AsyncRequestCallback<ListCustomerSubscriptionsResponse> callback = new AsyncRequestCallback<ListCustomerSubscriptionsResponse>(ListCustomerSubscriptionsResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncListCustomerSubscriptionsRequest(this.publisherToken, this.customerEmail,0, 20, callback));
        this.api.listCustomerSubscriptionsAsync(requests);
        TimeUnit.SECONDS.sleep(5);
        final ListCustomerSubscriptionsResponse response = callback.getResponse();
        assertNotNull(response);
        assertNull(response.error);
    }

    @Test
    @Ignore
    public void testDeletePaymentDetails() throws IOException {
        final BooleanResponse response = this.api.deletePaymentDetails("593681774");
        assertNotNull(response);
        assertTrue("Should be able to delete new payment", response.result.success);
    }

    @Test
    @Ignore
    public void testDeletePaymentDetailsAsync() throws IOException, InterruptedException {
        final DeletePaymentDetailsParams input = new DeletePaymentDetailsParams("593681774");
        final AsyncRequestCallback<BooleanResponse> callback = new AsyncRequestCallback<BooleanResponse>(BooleanResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(input, callback));
        this.api.deletePaymentDetailsAsync(requests);
        TimeUnit.SECONDS.sleep(5);
        final BooleanResponse response = callback.getResponse();
        assertNotNull(response);
        assertTrue("Should be able to delete new payment", response.result.success);
    }

    @Test
    public void testIsTrialAllowed() throws IOException {
        final BooleanResponse response = this.api.isTrialAllowed(this.customerEmail, "S587628980_PL");
        assertNotNull(response);
        assertFalse(response.result.success);
    }

    @Test
    public void testIsTrialAllowedAsync() throws IOException, InterruptedException {
        final IsTrialAllowedParams input = new IsTrialAllowedParams(this.customerEmail, "S587628980_PL");
        final AsyncRequestCallback<BooleanResponse> callback = new AsyncRequestCallback<BooleanResponse>(BooleanResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(input, callback));
        this.api.isTrialAllowedAsync(requests);
        TimeUnit.SECONDS.sleep(5);
        final BooleanResponse response = callback.getResponse();
        assertNotNull(response);
        assertFalse("Trial should not be allowed", response.result.success);
    }

    @Test
    @Ignore
    public void testListOfferIdsByVideoId() throws IOException {
        final ListOfferIdsByVideoIdResponse response = this.api.listOfferIdsByVideoId("7777");
        assertNotNull(response);
        assertTrue(response.result.offerIds.size() > 0);
    }

    @Test
    @Ignore
    public void testListOfferIdsByVideoIdAsync() throws IOException, InterruptedException {
        final VideoIdParams input = new VideoIdParams("7777");
        final AsyncRequestCallback<ListOfferIdsByVideoIdResponse> callback = new AsyncRequestCallback<ListOfferIdsByVideoIdResponse>(ListOfferIdsByVideoIdResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(input, callback));
        this.api.listOfferIdsByVideoIdAsync(requests);
        TimeUnit.MILLISECONDS.sleep(16000);
        final ListOfferIdsByVideoIdResponse response = callback.getResponse();
        assertNotNull(response);
        assertTrue(response.result.offerIds.size() > 0);
    }

    @Test
    public void testGetAccessStatusForDevice() throws IOException {
        final GetAccessStatusForDeviceResponse response = this.api.getAccessStatusForDevice(this.customerToken, "S222742070_PL", "1", "roku");
        assertNotNull(response);
        assertTrue(response.result.accessGranted);
    }

    @Test
    public void testGetAccessStatusForDeviceAsync() throws IOException, InterruptedException {
        final GetAccessStatusForDeviceParams params = new GetAccessStatusForDeviceParams(this.customerToken, "S222742070_PL", "1", "roku");
        final GetAccessStatusForDeviceParams params2 = new GetAccessStatusForDeviceParams(this.customerToken, "S222742070_PL", "1", "roku");
        final AsyncRequestCallback<GetAccessStatusForDeviceResponse> callback = new AsyncRequestCallback<GetAccessStatusForDeviceResponse>(GetAccessStatusForDeviceResponse.class);
        final AsyncRequestCallback<GetAccessStatusForDeviceResponse> callback2 = new AsyncRequestCallback<GetAccessStatusForDeviceResponse>(GetAccessStatusForDeviceResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncRequest(params, callback));
        requests.add(new AsyncRequest(params2, callback2));
        this.api.getAccessStatusForDeviceAsync(requests);
        TimeUnit.SECONDS.sleep(10);
        final GetAccessStatusForDeviceResponse response = callback.getResponse();
        final GetAccessStatusForDeviceResponse response2 = callback2.getResponse();
        assertNotNull(response);
        assertNotNull(response2);
        assertTrue(response.result.accessGranted);
        assertTrue(response2.result.accessGranted);
    }

    @Test
    public void testInvokeBatchAsync() throws IOException, InterruptedException {
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
        final OfferRequest createOffer = new OfferRequest("createSubscriptionOffer", OfferParams.create(this.publisherToken, offerData));
        final ListRequest listOffers = new ListRequest("listSubscriptionOffers", ListParams.create(this.publisherToken, new Criteria(true), 0, 10));
        final BatchAsyncRequest batch = new BatchAsyncRequest();
        batch.addRequest(createOffer);
        batch.addRequest(listOffers);
        this.api.invokeBatchAsync(batch);
        TimeUnit.SECONDS.sleep(4);
        final BatchResponse response = batch.getResponse();
        Assert.assertNotNull(response);
        Assert.assertEquals("Number of responses should match number of requests in a batch", 2, response.responses.size());
    }

    @Test
    public void testInvokeBatch() throws IOException, InterruptedException {
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
        final OfferRequest createOffer = new OfferRequest("createSubscriptionOffer", OfferParams.create(this.publisherToken, offerData));
        final ListRequest listOffers = new ListRequest("listSubscriptionOffers", ListParams.create(this.publisherToken, new Criteria(true), 0, 10));
        final BatchRequest batch = new BatchRequest();
        batch.addRequest(createOffer);
        batch.addRequest(listOffers);
        final BatchResponse response = this.api.invokeBatch(batch);
        Assert.assertNotNull(response);
        Assert.assertEquals("Number of responses should match number of requests in a batch", 2, response.responses.size());
    }

    @Test
    public void testUpdateBroadcasterSpecificPersonalDataWithCaptureAnswers() throws IOException {

        ArrayList<Answer> customAnswers = new ArrayList<>();
        customAnswers.add(new Answer("custom_1", "zipcode", "10002"));

        final BooleanResponse response = this.api.updateBroadcasterSpecificPersonalDataWithCaptureAnswers(250897629, new PersonalData("John",
            "Doe",
            "445 Mount Eden Road",
            "Mount Eden",
            "Auckland",
            null,
            "New Zealand",
            null,
            null,
            null,
            null,
            714418052,
            customAnswers
        ));

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.result);
        Assert.assertTrue(response.result.success);
    }

    @Test
    public void testUpdateBroadcasterSpecificPersonalDataWithCaptureAnswersAsync() throws IOException, InterruptedException {

        ArrayList<Answer> customAnswers = new ArrayList<>();
        customAnswers.add(new Answer("custom_1", "zipcode", "10002"));

        final List<AsyncRequest> requests = new ArrayList<>();
        final AsyncRequestCallback<BooleanResponse> callback = new AsyncRequestCallback<>(BooleanResponse.class);
        final PersonalDataParams params = new PersonalDataParams(this.publisherToken, 250897629, new PersonalData("John",
            "Doe",
            "445 Mount Eden Road",
            "Mount Eden",
            "Auckland",
            null,
            "New Zealand",
            null,
            null,
            null,
            null,
            714418052,
            customAnswers
        ));

        requests.add(new AsyncRequest(params, callback));

        this.api.updateBroadcasterSpecificPersonalDataWithCaptureAnswersAsync(requests);

        TimeUnit.SECONDS.sleep(5);

        final BooleanResponse response = callback.getResponse();

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.result);
        Assert.assertTrue(response.result.success);
    }

    @Test
    public void testFetchBroadcasterSpecificPersonalDataWithCaptureAnswers() throws IOException {

        final PersonalDataResponse response = this.api.fetchBroadcasterSpecificPersonalDataWithCaptureAnswers(250897629);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.result);
    }

    @Test
    public void testFetchBroadcasterSpecificPersonalDataWithCaptureAnswersAsync() throws IOException, InterruptedException {

        final List<AsyncRequest> requests = new ArrayList<>();
        final AsyncRequestCallback<PersonalDataResponse> callback = new AsyncRequestCallback<>(PersonalDataResponse.class);
        requests.add(new AsyncRequest(new UserParams(this.publisherToken,250897629), callback));

        this.api.fetchBroadcasterSpecificPersonalDataWithCaptureAnswersAsync(requests);

        TimeUnit.SECONDS.sleep(5);
        final PersonalDataResponse response = callback.getResponse();

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.result);
    }

    @Test
    public void testSaveCaptureQuestions() throws IOException {

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("custom_1", true, true, true, "value", "Question1?"));

        BooleanResponse response = this.api.saveCaptureQuestions(questions);

        Assert.assertNotNull(response);
        Assert.assertTrue(response.result.success);
    }

    @Test
    public void testSaveCaptureQuestionsAsync() throws IOException, InterruptedException {

        List<AsyncRequest> requests = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("custom_1", true, true, true, "value", "Question1?"));
        AsyncRequestCallback<BooleanResponse> callback = new AsyncRequestCallback<>(BooleanResponse.class);
        requests.add(new AsyncRequest(new QuestionsParams(this.publisherToken, questions), callback));

        this.api.saveCaptureQuestionsAsync(requests);

        TimeUnit.SECONDS.sleep(5);

        BooleanResponse response = callback.getResponse();

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.result);
    }

    @Test
    public void testFetchCaptureQuestions() throws IOException {

        CaptureQuestionResponse response = this.api.fetchCaptureQuestions();

        Assert.assertNotNull(response);
        Assert.assertTrue(response.result.size() > 0);
    }

    @Test
    public void testFetchCaptureQuestionsAsync() throws IOException, InterruptedException {

        List<AsyncRequest> requests = new ArrayList<>();
        AsyncRequestCallback<CaptureQuestionResponse> callback = new AsyncRequestCallback<>(CaptureQuestionResponse.class);
        requests.add(new AsyncRequest(new QuestionsParams(this.publisherToken), callback));

        this.api.fetchCaptureQuestionsAsync(requests);

        TimeUnit.SECONDS.sleep(5);

        CaptureQuestionResponse response = callback.getResponse();

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.result);
        Assert.assertTrue(response.result.size() > 0);
    }

    private long getSleepTime(int requests) {
        double sleepTime = this.sleepRatio * requests * 1000;
        return (long) sleepTime;
    }
}
