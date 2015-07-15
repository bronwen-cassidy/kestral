package com.xioq.kestral.services;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Client;
import com.xioq.kestral.model.Provider;
import com.xioq.kestral.model.Schedule;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@Transactional
public class SchedulingServiceImplTest extends DefaultServiceTest {

    @Autowired
    private SchedulingService schedulingService;

    @Test
    public void testViewDailySchedule() {
        Provider provider = new Provider(-1L);
        Schedule dailySchedule = schedulingService.findTodaysSchedule(provider);
        assertNotNull(dailySchedule);
    }
    @Test
    public void testDailyScheduleTodaysDate() {
        Provider provider = new Provider(-1L);
        Schedule dailySchedule = schedulingService.findTodaysSchedule(provider);
        DateTime dt = DateTime.now();
        DateTimeFormatter fmt = DateConstants.DATE_TIME_FORMATTER;
        assertEquals(fmt.print(dt), dailySchedule.getStartDate());
    }

    @Test
    @DatabaseSetup("SchedulingServiceImplTest.testScheduleHasAppointments.xml")
    public void testScheduleHasAppointments() {
        // add some appointments to the database - lets use dbunit

        Provider provider = new Provider(-2L);
        Schedule dailySchedule = schedulingService.findTodaysSchedule(provider);
        List<Appointment> appointments = dailySchedule.getAppointments();
        assertEquals(2, appointments.size());
    }

    @Test
    @DatabaseSetup("SchedulingServiceImplTest.testScheduleSearches.xml")
    public void testFindScheduleForClient() throws Exception {
        Client client = new Client(-2L);
        DateTime start = DateConstants.DATE_TIME_FORMATTER.parseDateTime("2011-05-04");
        DateTime end = DateConstants.DATE_TIME_FORMATTER.parseDateTime("2016-05-08");
        Schedule s = schedulingService.find(client, start.toDate(), end.toDate());
        assertEquals(7, s.getAppointments().size());
    }

    @Test
    @DatabaseSetup("SchedulingServiceImplTest.testScheduleHasAppointments.xml")
    public void testAppointmentsHaveProvider() {
        // add some appointments to the database - lets use dbunit

        Provider p = new Provider(-2L);
        Schedule dailySchedule = schedulingService.findTodaysSchedule(p);
        List<Appointment> appointments = dailySchedule.getAppointments();
        assertEquals(2, appointments.size());
        for (Appointment appointment : appointments) {
            // client attends an appointment with
            Provider provider = appointment.getProvider();
            assertNotNull(provider);
            assertEquals("Peter", provider.getUser().getFirstName());
        }
    }

    @Test
    @DatabaseSetup("SchedulingServiceImplTest.testScheduleSearches.xml")
    public void testAppointmentsForProvider() {
        // add some appointments to the database - lets use dbunit
        Provider niall = new Provider(-3L);
        DateTimeFormatter formatter = DateConstants.DATE_TIME_FORMATTER;
        DateTime start = formatter.parseDateTime("2015-05-04");
        DateTime end = formatter.parseDateTime("2015-05-08");
        Schedule schedule = schedulingService.find(niall, start.toDate(), end.toDate());
        List<Appointment> appointments = schedule.getAppointments();
        assertEquals(4, appointments.size());
    }
}