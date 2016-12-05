package com.cleeng.api;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.net.MalformedURLException;

public class CleengFactoryTest {

    private String publisherToken = "IEiuf3fJzAorVvxgBYiHiHXGk8oFPckTMSOn8hS1--lOti30";

    @Test
    public void testCreateSandboxApi() throws MalformedURLException {
        final Cleeng api = CleengFactory.createSandboxApi(publisherToken);
        assertNotNull(api);
    }
}
