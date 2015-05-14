package com.xioq.kestral;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Client;
import com.xioq.kestral.model.Company;
import com.xioq.kestral.model.Provider;
import com.xioq.kestral.services.AppointmentService;
import com.xioq.kestral.services.ClientService;
import com.xioq.kestral.services.ProviderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class AppointmentServiceImplTest {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProviderService providerService;

    @Test
    @DatabaseSetup("AppointmentServiceImplTest.testFindAllForCompany.xml")
    public void testFindAllForCompany() {
        // add some appointments to the database - lets use dbunit
        Company c = new Company(-2L);
        List<Appointment> appointments = appointmentService.findAll(c);
        assertEquals(7, appointments.size());
    }

    @Test
    @DatabaseSetup("AppointmentServiceImplTest.testFindAllForCompany.xml")
    public void testFindAllForProvider() {
        // add some appointments to the database - lets use dbunit
        Company c = new Company(-2L);
        Provider provider = new Provider(-3L);
        List<Appointment> appointments = appointmentService.findAll(provider);
        assertEquals(6, appointments.size());
    }

    @Test
    @DatabaseSetup("AppointmentServiceImplTest.testFindAllForCompany.xml")
    public void testFindAllForClient() {
        // add some appointments to the database - lets use dbunit
        Client c = new Client(-1L);
        List<Appointment> appointments = appointmentService.findAll(c);
        assertEquals(2, appointments.size());
    }

    @Test
    @DatabaseSetup("AppointmentServiceImplTest.testAppointment.xml")
    public void testAddAppointment() throws Exception {
        Appointment appointment = new Appointment();
        appointment.setClient(clientService.findById(new Long(-1)));
        appointment.setProvider(providerService.findById(new Long(-3)));
        appointment.setCompany(new Company(-2L));

        Appointment savedAppointment = appointmentService.save(appointment);
        assertNotNull(savedAppointment.getId());
    }

    @Test
    @DatabaseSetup("AppointmentServiceImplTest.testAppointment.xml")
    public void testUpdateAppointment() throws Exception {
        Appointment appointment = new Appointment();
        appointment.setClient(clientService.findById(new Long(-1)));
        appointment.setProvider(providerService.findById(new Long(-3)));
        appointment.setCompany(new Company(-2L));

        Appointment savedAppointment = appointmentService.save(appointment);
        assertNotNull(savedAppointment.getId());
    }

}
