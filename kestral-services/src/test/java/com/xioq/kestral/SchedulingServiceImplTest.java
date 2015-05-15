package com.xioq.kestral;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.xioq.kestral.model.*;
import com.xioq.kestral.services.DateConstants;
import com.xioq.kestral.services.SchedulingService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class SchedulingServiceImplTest {

    @Autowired
    private SchedulingService schedulingService;

    @Test
    public void testViewDailySchedule() {
        Company company = new Company(-1L);
        Schedule dailySchedule = schedulingService.findTodaysSchedule(company);
        assertNotNull(dailySchedule);
    }
    @Test
    public void testDailyScheduleTodaysDate() {
        Company company = new Company(-1L);
        Schedule dailySchedule = schedulingService.findTodaysSchedule(company);
        DateTime dt = DateTime.now();
        DateTimeFormatter fmt = DateConstants.DATE_TIME_FORMATTER;
        assertEquals(fmt.print(dt), dailySchedule.getStartDate());
    }

    @Test
    @DatabaseSetup("SchedulingServiceImplTest.testScheduleHasAppointments.xml")
    public void testScheduleHasAppointments() {
        // add some appointments to the database - lets use dbunit

        Company company = new Company(-1L);
        Schedule dailySchedule = schedulingService.findTodaysSchedule(company);
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

        Company company = new Company(-1L);
        Schedule dailySchedule = schedulingService.findTodaysSchedule(company);
        List<Appointment> appointments = dailySchedule.getAppointments();
        assertEquals(2, appointments.size());
        for (Appointment appointment : appointments) {
            // client attends an appointment with
            Provider provider = appointment.getProvider();
            assertNotNull(provider);
            assertEquals("Mary", provider.getFirstName());
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