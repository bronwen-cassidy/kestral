package com.xioq.kestral.services;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.xioq.kestral.model.Provider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by bronwen.cassidy on 24/06/2015
 */
@Transactional
public class ProviderServiceImplTest extends DefaultServiceTest {

    @Autowired
    ProviderService providerService;

    @Test
    @DatabaseSetup("ProviderServiceImplTest.testFind.xml")
    public void testFindAll() throws Exception {
        List<Provider> providers = providerService.findAll(-1L);
        assertEquals(1, providers.size());
        Provider provider = providers.get(0);
        assertEquals("OBrian", provider.getUser().getSecondName());
    }
}