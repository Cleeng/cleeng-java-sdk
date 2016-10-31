package com.cleeng.api;

import com.cleeng.api.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

        final OfferData offerData = new OfferData(12.34,
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

        final OfferResponse response = this.api.createSubscriptionOffer( offerData );
        assertNotNull( response );
        assertEquals( "offer title should equal", offerData.title, response.result.title );
    }

    @Test
    public void testCreateSingleOffer() throws IOException {

        final SingleOfferData offerData = new SingleOfferData(12.34,
                "week",
                "some title",
                "http://www.youtube.com",
                "desc",
                0,
                0,
                Arrays.asList("sport"),
                true,
                "whitelist",
                Arrays.asList("PL"),
                "7777",
                "778",
                "6",
                Arrays.asList("sport", "dance")
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
                "title",
                "http://www.someurl.com",
                "description",
                "9A",
                "90",
                1900000000,
                1999999999,
                "America/New_York",
                "7777",
                "2",
                "teaser",
                true,
                Arrays.asList("Sport", "Entertainment"),
                true,
                "whitelist",
                Arrays.asList("PL", "DE"),
                "http://www.somedomain.com"
        );

        final EventOfferResponse response = this.api.createEventOffer( offerData );
        assertNotNull( response );
        assertEquals( "offer title should equal", offerData.title, response.result.title );
        assertEquals( "tags should match", offerData.teaser, response.result.teaser );
    }
}
