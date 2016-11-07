package com.cleeng.api;

import com.cleeng.api.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jesion on 2016-10-28.
 */
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
            "http://www.youtube.com",
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
        assertNotNull( response );
        assertNotNull( response.result.accessToTags );
        assertEquals( "offer title should equal", offerData.title, response.result.title );
    }

    @Test
    public void testCreateSingleOffer() throws IOException {

        final SingleOfferData offerData = new SingleOfferData(12.34,
            "title",
            "http://www.somedomain.com",
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

        final SingleOfferResponse response = this.api.createSingleOffer( offerData );
        assertNotNull( response );
        assertEquals( "offer title should equal", offerData.title, response.result.title );
        assertEquals( "videoId should match", offerData.videoId, response.result.videoId );
    }

    @Test
    public void testCreateEventOffer() throws IOException {

        final EventOfferDataRequest offerData = new EventOfferDataRequest( 12.34,
            "GBP",
            "titleval",
            "http://www.youtube.com",
            "desc",
            "9A",
            "90",
            "http://www.somedomain.com",
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

        final EventOfferResponse response = this.api.createEventOffer( offerData );
        assertNotNull( response );
        assertEquals( "offer title should equal", offerData.title, response.result.title );
        assertEquals( "teaser should match", offerData.teaser, response.result.teaser );
    }

    @Test
    public void testCreateRentalOffer() throws IOException {

        final RentalOfferData offerData = new RentalOfferData( 12.34,
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

        final RentalOfferResponse response = this.api.createRentalOffer( offerData );
        assertNotNull( response );
        assertEquals( "offer title should equal", offerData.title, response.result.title );
        assertEquals( "period should match", offerData.period, response.result.period );
    }

    @Test
    public void testCreatePassOffer() throws IOException {

        final PassOfferData offerData = new PassOfferData( 12.34,
            null,
            1900000000,
            "title",
            "http://www.somedomain.com",
            null,
            "description",
            Arrays.asList("Sport"),
            true,
            "whitelist",
            Arrays.asList("PL","DE")
        );

        final PassOfferResponse response = this.api.createPassOffer( offerData );
        assertNotNull( response );
        assertEquals( "offer title should equal", offerData.title, response.result.title );
        assertEquals( "period should match", offerData.expiresAt, response.result.expiresAt );

    }

    @Test
    public void testCreatePassOfferError() throws IOException {

        final PassOfferData offerData = new PassOfferData( 12.34,
                "month",
                1900000000,
                "title",
                "http://www.somedomain.com",
                null,
                "description",
                Arrays.asList("Sport"),
                true,
                "whitelist",
                Arrays.asList("PL","DE")
        );

        final PassOfferResponse response = this.api.createPassOffer( offerData );
        assertNotNull( response );
        assertNull( response.result );
        assertNotNull (response.error );
        assertEquals( "error code should match ", 8, response.error.code );
    }

    @Test
    public void testListSubscriptionOffers() throws IOException {

        final Criteria criteria = new Criteria( true );
        final ListSubscriptionOffersResponse response = this.api.listSubscriptionOffers( criteria, 0, 10 );
        assertNotNull( response );
        assertEquals("list length should match", 10, response.result.items.size());
    }

    @Test
    public void testListSingleOffers() throws IOException {

        final Criteria criteria = new Criteria( true );
        final ListSingleOffersResponse response = this.api.listSingleOffers( criteria, 0, 10 );
        assertNotNull( response );
        assertEquals("list length should match", 10, response.result.items.size());
    }

    @Test
    public void testListPassOffers() throws IOException {

        final Criteria criteria = new Criteria( true );
        final ListPassOffersResponse response = this.api.listPassOffers( criteria, 0, 10 );
        assertNotNull( response );
        assertEquals("list length should match", 10, response.result.items.size());
    }

    @Test
    public void testPrepareRemoteAuth() throws IOException {

        final CustomerData customerData = new CustomerData( "johndoe@gmail.com", "en_US", "GBP", "PL" );
        final FlowDescription flowDescription = new FlowDescription( 8, "http://www.wp.pl" );
        final PrepareRemoteAuthResponse response = this.api.prepareRemoteAuth( customerData, flowDescription );
        assertNotNull( response );
        assertTrue(response.result.url.length() > 0);
    }

    @Test
    public void testGenerateCustomerToken() throws IOException {

        final GenerateCustomerTokenResponse response = this.api.generateCustomerToken( "testjohndoe2@gmail.com" );
        assertNotNull( response );
        assertNull( response.error );
        assertNotNull( response.result.token );
    }

    @Test
    public void testGetAccessStatus() throws IOException {

        final GetAccessStatusResponse response = this.api.getAccessStatus( "Apx8VULFtQJgyQmuM4Jha3uLIJJQCmfnEGwFnxIFiBlPxGcI", "A334745341_PL", "78.129.213.71" );
        assertNotNull( response.result );
        assertEquals( "Access granted should match", false, response.result.accessGranted );
        assertEquals( "ExpiresAt should match", 0, response.result.expiresAt );
        assertEquals( "PurchasedDirectly should match", false, response.result.purchasedDirectly );
    }

    @Test
    public void testGetAccessibleTags() throws IOException {

        final GetAccessibleTagsResponse response = this.api.getAccessibleTags( this.publisherToken, "Apx8VULFtQJgyQmuM4Jha3uLIJJQCmfnEGwFnxIFiBlPxGcI" );
        assertNotNull( response.result );
        assertNotNull( response.result.tags );
    }
}
