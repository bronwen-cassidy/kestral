package com.xioq.kestral.services;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.xioq.kestral.model.Address;
import com.xioq.kestral.model.Client;
import com.xioq.kestral.model.Company;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by bronwen.cassidy on 18/05/2015.
 */

public class ClientServiceImplTest extends DefaultServiceTest {

    @Autowired
    private ClientService clientService;

    @Test
    @DatabaseSetup("ClientServiceImplTest.testClient.xml")
    public void testCreateClient() throws Exception {

        Client c = new Client();
        c.setCompany(new Company(-1L));
        c.setFirstName("Bronwen");
        c.setSecondName("Cassidy");
        Address address = new Address();
        address.setPostCode("EN5 4LR");
        c.setAddress(address);
        c.setContactTelephone("+353877297152");
        c.setContactEmail("bronwen_cassidy@yahoo.co.uk");

        Client expected = clientService.save(c);
        Client actual = clientService.findById(expected.getId());

        assertEquals(expected, actual);

    }

    @Test
    @DatabaseSetup("ClientServiceImplTest.testClient.xml")
    public void testUpdateClient() throws Exception {

        Client expected = clientService.findById(-2L);
        expected.setSecondName("Cassidy");
        clientService.update(expected);

        Client actual = clientService.findById(expected.getId());

        assertEquals(expected, actual);

    }
}