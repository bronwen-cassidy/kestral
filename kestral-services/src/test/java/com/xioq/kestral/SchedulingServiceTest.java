package com.xioq.kestral;

import com.xioq.kestral.model.Appointment;
import com.xioq.kestral.model.Company;
import com.xioq.kestral.model.Schedule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class,
        classes={SchedulingService.class})
@ActiveProfiles("dev")
public class SchedulingServiceTest {

    @Autowired
    SchedulingService schedulingService;

    @Test
    public void testViewDailySchedule() {
        Company company = new Company();
        company.setId(new Long(-1));
        Schedule dailySchedule = schedulingService.findTodaysSchedule(company);
        List<Appointment> appointments = dailySchedule.getAppointments();
    }
}