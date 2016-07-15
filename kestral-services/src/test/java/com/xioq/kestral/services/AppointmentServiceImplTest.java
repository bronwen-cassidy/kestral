package com.xioq.kestral.services;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.xioq.kestral.services.appointments.Appointment;
import com.xioq.kestral.services.clients.Client;
import com.xioq.kestral.services.providers.Company;
import com.xioq.kestral.services.providers.Provider;
import com.xioq.kestral.services.appointments.AppointmentService;
import com.xioq.kestral.services.clients.ClientService;
import com.xioq.kestral.services.providers.ProviderService;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple App.
 */
@Transactional
public class AppointmentServiceImplTest extends DefaultServiceTest {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProviderService providerService;

    @Test
    @DatabaseSetup("AppointmentServiceImplTest.testFindAllForCompany.xml")
    public void testFindAllForProvider() {
        // add some appointments to the database - lets use dbunit
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
        appointment.setClient(clientService.findById(-1L));
        appointment.setProvider(providerService.findById(-3L));

        Appointment savedAppointment = appointmentService.save(appointment);
        assertNotNull(savedAppointment.getId());
    }

    @Test
    @DatabaseSetup("AppointmentServiceImplTest.testAppointment.xml")
    public void testUpdateAppointmentNewProvider() throws Exception {
        Appointment appointment = appointmentService.findById(-8L);
        final Provider provider = new Provider(-6L);
        appointment.setProvider(provider);
        appointmentService.save(appointment);
        
        Appointment updated = appointmentService.findById(-8L);
        assertEquals(new Long(-6), updated.getProvider().getId());
    }

    @Test
    @DatabaseSetup("AppointmentServiceImplTest.testAppointment.xml")
    public void testUpdateAppointmentNewTime() throws Exception {
        Appointment appointment = appointmentService.findById(-8L);
        
        appointment.setStartTime("13:30");
        appointment.setEndTime("14:30");
        
        appointmentService.save(appointment);

        Appointment updated = appointmentService.findById(-8L);
        assertEquals("13:30", updated.getStartTime());
    }

    @Test
    @DatabaseSetup("AppointmentServiceImplTest.testAppointment.xml")
    public void testUpdateAppointmentNewDateTime() throws Exception {
        Appointment appointment = appointmentService.findById(-8L);
        appointment.setStartTime("14:30");
        appointment.setEndTime("15:30");

        final Date appointmentDate = DateConstants.DATE_TIME_FORMATTER.parseDateTime("2015-06-22").toDate();
        appointment.setAppointmentDate(appointmentDate);
        appointmentService.save(appointment);

        Appointment updated = appointmentService.findById(-8L);
        assertEquals(appointmentDate, updated.getAppointmentDate());
    }

    @Test
    @DatabaseSetup("AppointmentServiceImplTest.testAppointment.xml")
    public void testCancelAppointment() throws Exception {
        Appointment appointment = appointmentService.findById(-8L);
        
        // cancel means throw it away? or archive it, for now throw it away
        boolean success = appointmentService.cancelAppointment(appointment);
        assertEquals(Boolean.TRUE, Boolean.valueOf(success));
    }

    @Test
    @DatabaseSetup("AppointmentServiceImplTest.testMakeAppointment.xml")
    public void testFindAvailableAppointments() throws Exception {
        
        // step 1) findById an available appointment slots for a given time period and company and provider
        Company c = new Company(-2L);
        Provider p = new Provider(-3L);
        DateTime startPeriod = DateConstants.DATE_TIME_FORMATTER.parseDateTime("2015-05-04");
        DateTime endPeriod = DateConstants.DATE_TIME_FORMATTER.parseDateTime("2015-05-04");
        // we should split the availability into days??
        List<Appointment> availableSlots = appointmentService.findAvailableAppointmentSlots(c, p, startPeriod.toDate(), endPeriod.toDate());
        assertEquals("There are 2 here as we have not taken into consideration the lunch period or even breaks", 2, availableSlots.size());
    }

    @Test
    @DatabaseSetup("AppointmentServiceImplTest.testMakeAppointment.xml")
    public void testMakeAppointment() throws Exception {

        Company c = new Company(-2L);
        Provider p = new Provider(-3L);
        DateTime startPeriod = DateConstants.DATE_TIME_FORMATTER.parseDateTime("2015-05-04");
        // take the first one
        Client client = new Client(-2L);
        String startTime = "11:30";
        Appointment expected = appointmentService.makeAppointment(c, p, client, startPeriod.toDate(), startTime);

        // findById the appointment
        Appointment actual = appointmentService.findById(expected.getId());
        assertEquals(expected, actual);

    }

}
