package com.cleeng.api;

import com.cleeng.api.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("unchecked")
public class CleengImplTest {

    private String publisherToken = "IEiuf3fJzAorVvxgBYiHiHXGk8oFPckTMSOn8hS1--lOti30";

    private Cleeng api;

    @Before
    public void setUp() throws MalformedURLException {
        this.api = CleengFactory.createSandboxApi(publisherToken);
    }

    @After
    public void tearDown() {
        this.api = null;
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

        assertEquals("Lock queue should be empty", 0, requests.get(0).latch.getCount());

        final OfferResponse response = callback.getResponse();

        assertNotNull("Response object should not be null", response);
        assertEquals("Average rating should match", 4, response.result.averageRating);
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
        requests.add(new AsyncRequest(offerData, callback));

        this.api.createSingleOfferAsync(requests);

        assertEquals("Lock queue should be empty", 0, requests.get(0).latch.getCount());

        final SingleOfferResponse response = callback.getResponse();

        assertNotNull("Response object should not be null", response);
        assertEquals("Average rating should match", true, response.result.active);
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
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, new AsyncRequestCallback<EventOfferResponse>(EventOfferResponse.class)));
        requests.add(new AsyncRequest(offerData, callback));

        this.api.createEventOfferAsync(requests);

        assertEquals("Lock queue should be empty", 0, requests.get(0).latch.getCount());

        final EventOfferResponse response = callback.getResponse();

        assertNotNull("Response object should not be null", response);
        assertEquals("Active should match", true, response.result.active);
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
        requests.add(new AsyncRequest(offerData, callback));

        this.api.createRentalOfferAsync(requests);

        assertEquals("Lock queue should be empty", 0, requests.get(0).latch.getCount());

        final RentalOfferResponse response = callback.getResponse();

        assertNotNull("Response object should not be null", response);
        assertEquals("Active should match", true, response.result.active);
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
        requests.add(new AsyncRequest(offerData, callback));

        this.api.createPassOfferAsync(requests);

        assertEquals("Lock queue should be empty", 0, requests.get(0).latch.getCount());

        final PassOfferResponse response = callback.getResponse();

        assertNotNull("Response object should not be null", response);
        assertEquals("Active should match", true, response.result.active);
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
        requests.add(new AsyncListRequest(new Criteria(true), callback, 0, 10 ) );
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListSubscriptionOffersResponse>(ListSubscriptionOffersResponse.class), 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListSubscriptionOffersResponse>(ListSubscriptionOffersResponse.class), 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListSubscriptionOffersResponse>(ListSubscriptionOffersResponse.class), 0, 10));
        requests.add(new AsyncListRequest(new Criteria(true), new AsyncRequestCallback<ListSubscriptionOffersResponse>(ListSubscriptionOffersResponse.class), 0, 10));

        this.api.listSubscriptionOffersAsync(requests);

        assertEquals("Lock queue should be empty", 0, requests.get(0).latch.getCount());

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

        assertEquals("Lock queue should be empty", 0, requests.get(0).latch.getCount());

        final ListSingleOffersResponse response = callback.getResponse();

        assertNotNull("Response object should not be null", response);
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

        assertEquals("Lock queue should be empty", 0, requests.get(0).latch.getCount());

        final ListPassOffersResponse response = callback.getResponse();

        assertNotNull("Response object should not be null", response);
        assertTrue("List should contain items", response.result.items.size() > 0);
    }

    @Test
    public void testPrepareRemoteAuth() throws IOException {

        final CustomerData customerData = new CustomerData("johndoe@gmail.com", "en_US", "GBP", "PL");
        final FlowDescription flowDescription = new FlowDescription("8", "http://www.someurl.com");
        final PrepareRemoteAuthResponse response = this.api.prepareRemoteAuth(customerData, flowDescription);
        assertNotNull(response);
        assertTrue(response.result.url.length() > 0);
    }

    @Test
    public void testPrepareRemoteAuthAsync() throws IOException, InterruptedException {

        final CustomerData customerData = new CustomerData("johndoe@gmail.com", "en_US", "GBP", "PL");
        final FlowDescription flowDescription = new FlowDescription("8", "http://www.someurl.com");
        final AsyncRequestCallback<PrepareRemoteAuthResponse> callback = new AsyncRequestCallback<PrepareRemoteAuthResponse>(PrepareRemoteAuthResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncPrepareRemoteAuthRequest(customerData, flowDescription, callback));

        this.api.prepareRemoteAuthAsync(requests);

        assertEquals("Lock queue should be empty", 0, requests.get(0).latch.getCount());

        final PrepareRemoteAuthResponse response = callback.getResponse();

        assertNotNull("Response object should not be null", response);
        assertTrue("List should contain items", response.result.url.length() > 0);
    }

    @Test
    public void testGenerateCustomerToken() throws IOException {

        final GenerateCustomerTokenResponse response = this.api.generateCustomerToken("testjohndoe2@gmail.com");
        assertNotNull(response);
        assertNull(response.error);
        assertNotNull(response.result.token);
    }

    @Test
    public void testGenerateCustomerTokenAsync() throws IOException, InterruptedException {

        final AsyncRequestCallback<GenerateCustomerTokenResponse> callback = new AsyncRequestCallback<GenerateCustomerTokenResponse>(GenerateCustomerTokenResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncTokenRequest(callback, "testjohndoe2@gmail.com"));

        final List<String> tokens = new ArrayList<String>();
        final int count = 100;

        for (int i = 1; i < count; i++) {
            requests.add( new AsyncTokenRequest( new AsyncRequestCallback<GenerateCustomerTokenResponse>(GenerateCustomerTokenResponse.class), "testjohndoe2@gmail.com"));
        }

        this.api.generateCustomerTokenAsync(requests);

        assertEquals("Lock queue should be empty", 0, requests.get(0).latch.getCount());

        final GenerateCustomerTokenResponse response = callback.getResponse();

        assertNotNull("Response object should not be null", response);
        assertNotNull("Response should contain token", response.result.token);

        for (int j = 0; j < requests.size(); j++) {
           tokens.add(((AsyncRequestCallback<GenerateCustomerTokenResponse>) requests.get(j).callback).getResponse().result.token);
        }

        assertEquals("Tokens array should match", 100, tokens.size());
    }

    @Test
    public void testGetAccessStatus() throws IOException {

        final GetAccessStatusResponse response = this.api.getAccessStatus("Apx8VULFtQJgyQmuM4Jha3uLIJJQCmfnEGwFnxIFiBlPxGcI", "A334745341_PL", "78.129.213.71");
        assertNotNull(response.result);
        assertEquals("Access granted should match", false, response.result.accessGranted);
        assertEquals("ExpiresAt should match", 0, response.result.expiresAt);
        assertEquals("PurchasedDirectly should match", false, response.result.purchasedDirectly);
    }

    @Test
    public void testGetAccessStatusAsync() throws IOException, InterruptedException {

        final AsyncRequestCallback<GetAccessStatusResponse> callback = new AsyncRequestCallback<GetAccessStatusResponse>(GetAccessStatusResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncGetAccessStatusRequest("Apx8VULFtQJgyQmuM4Jha3uLIJJQCmfnEGwFnxIFiBlPxGcI", "A334745341_PL", "78.129.213.71", callback));
        requests.add(new AsyncGetAccessStatusRequest("Apx8VULFtQJgyQmuM4Jha3uLIJJQCmfnEGwFnxIFiBlPxGcI", "A334745341_PL", "78.129.213.71", new AsyncRequestCallback<GetAccessStatusResponse>(GetAccessStatusResponse.class)));

        this.api.getAccessStatusAsync(requests);

        assertEquals("Lock queue should be empty", 0, requests.get(0).latch.getCount());

        final GetAccessStatusResponse response = callback.getResponse();

        assertNotNull("Response object should not be null", response);
        assertTrue("List should contain items", response.result.accessGranted == false);
    }

    @Test
    public void testGetAccessibleTags() throws IOException {

        final GetAccessibleTagsResponse response = this.api.getAccessibleTags(this.publisherToken, "Apx8VULFtQJgyQmuM4Jha3uLIJJQCmfnEGwFnxIFiBlPxGcI");
        assertNotNull(response.result);
        assertNotNull(response.result.tags);
    }

    @Test
         public void testGetAccessibleTagsAsync() throws IOException, InterruptedException {

        final AsyncRequestCallback<GetAccessibleTagsResponse> callback = new AsyncRequestCallback<GetAccessibleTagsResponse>(GetAccessibleTagsResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncGetAccessibleTagsRequest(this.publisherToken, "Apx8VULFtQJgyQmuM4Jha3uLIJJQCmfnEGwFnxIFiBlPxGcI", callback));
        requests.add(new AsyncGetAccessibleTagsRequest(this.publisherToken, "Apx8VULFtQJgyQmuM4Jha3uLIJJQCmfnEGwFnxIFiBlPxGcI", new AsyncRequestCallback<GetAccessibleTagsResponse>(GetAccessibleTagsResponse.class)));
        requests.add(new AsyncGetAccessibleTagsRequest(this.publisherToken, "Apx8VULFtQJgyQmuM4Jha3uLIJJQCmfnEGwFnxIFiBlPxGcI", new AsyncRequestCallback<GetAccessibleTagsResponse>(GetAccessibleTagsResponse.class)));

        this.api.getAccessibleTagsAsync(requests);

        assertEquals("Lock queue should be empty", 0, requests.get(0).latch.getCount());

        final GetAccessibleTagsResponse response = callback.getResponse();

        assertNotNull("Response object should not be null", response);
        assertTrue("List should contain items", response.result.tags.size() == 0);
    }

    @Test
    public void testGetAccessibleTagsAsyncNonBlocking() throws IOException, InterruptedException {

        final AsyncRequestCallback<GetAccessibleTagsResponse> callback = new AsyncRequestCallback<GetAccessibleTagsResponse>(GetAccessibleTagsResponse.class);
        final List<AsyncRequest> requests = new ArrayList<AsyncRequest>();
        requests.add(new AsyncGetAccessibleTagsRequest(this.publisherToken, "Apx8VULFtQJgyQmuM4Jha3uLIJJQCmfnEGwFnxIFiBlPxGcI", callback));
        requests.add(new AsyncGetAccessibleTagsRequest(this.publisherToken, "Apx8VULFtQJgyQmuM4Jha3uLIJJQCmfnEGwFnxIFiBlPxGcI", new AsyncRequestCallback<GetAccessibleTagsResponse>(GetAccessibleTagsResponse.class)));
        requests.add(new AsyncGetAccessibleTagsRequest(this.publisherToken, "Apx8VULFtQJgyQmuM4Jha3uLIJJQCmfnEGwFnxIFiBlPxGcI", new AsyncRequestCallback<GetAccessibleTagsResponse>(GetAccessibleTagsResponse.class)));

        this.api.setNonBlockingMode();
        this.api.getAccessibleTagsAsync(requests);

        callback.getCountdownLatch().await();

        final GetAccessibleTagsResponse response = callback.getResponse();

        assertNotNull("Response object should not be null", response);
        assertTrue("List should contain items", response.result.tags.size() == 0);
        assertTrue(true);
    }
}
