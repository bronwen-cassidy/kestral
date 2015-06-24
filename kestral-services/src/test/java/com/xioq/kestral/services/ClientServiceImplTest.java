package com.xioq.kestral.services;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.xioq.kestral.model.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by bronwen.cassidy on 18/05/2015
 */

public class ClientServiceImplTest extends DefaultServiceTest {

    @Autowired
    private ClientService clientService;

    @Test
    @DatabaseSetup("ClientServiceImplTest.testClient.xml")
    public void testCreateClient() throws Exception {

        Client c = new Client();
        User u = new User();
        u.setCompany(new Company(-1L));
        u.setFirstName("Bronwen");
        u.setSecondName("Cassidy");
        u.setUserType(UserType.CLIENT.toString());
        Address address = new Address();
        address.setPostCode("EN5 4LR");
        u.setAddress(address);
        u.setContactTelephone("+353877297152");
        u.setContactEmail("bronwen_cassidy@yahoo.co.uk");
        c.setUser(u);
        Client expected = clientService.save(c);
        Client actual = clientService.findById(expected.getId());

        assertEquals(expected, actual);

    }

    @Test
    @DatabaseSetup("ClientServiceImplTest.testClient.xml")
    public void testUpdateClient() throws Exception {

        Client expected = clientService.findById(-2L);
        User u = expected.getUser();
        u.setSecondName("Cassidy");
        clientService.update(expected);

        Client actual = clientService.findById(expected.getId());

        assertEquals(expected, actual);
        assertEquals(expected.getUser(), actual.getUser());

    }
}