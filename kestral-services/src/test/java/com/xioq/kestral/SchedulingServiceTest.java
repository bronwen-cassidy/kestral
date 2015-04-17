package com.xioq.kestral;

import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Company;
import com.xioq.kestral.model.Schedule;
import com.xioq.kestral.services.SchedulingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.unitils.UnitilsJUnit4;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@Transactional(TransactionMode.ROLLBACK)
public class SchedulingServiceTest extends UnitilsJUnit4 {

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        assertEquals(formatter.format(LocalDateTime.now()), dailySchedule.getStartDate());
    }
    @Test
    @DataSet("SchedulingServiceTest.testScheduleHasAppointments.xml")
    public void testScheduleHasAppointments() {
        // add some appointments to the database - lets use dbunit

        Company company = new Company(-1L);
        Schedule dailySchedule = schedulingService.findTodaysSchedule(company);
        List<Appointment> appointments = dailySchedule.getAppointments();
        assertEquals(2, appointments.size());
    }
}