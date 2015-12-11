package com.xioq.kestral.controller;

import com.xioq.kestral.services.providers.Provider;
import com.xioq.kestral.services.appointments.Schedule;
import com.xioq.kestral.services.DateConstants;
import com.xioq.kestral.services.appointments.SchedulingService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by bronwen.cassidy on 18/05/2015.
 *
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private SchedulingService schedulingService;

    @RequestMapping(value = "/provider/{providerId}/start/{startDate}/end/{endDate}", method = RequestMethod.GET,headers="Accept=application/json")
    public Schedule getSchedule(@PathVariable Long providerId, @PathVariable String startDate, @PathVariable String endDate) {

        Date start = DateConstants.DATE_TIME_FORMATTER.parseDateTime(startDate).toDate();
        Date end = DateConstants.DATE_TIME_FORMATTER.parseDateTime(endDate).toDate();

        return schedulingService.find(new Provider(providerId), start, end);
    }

    @RequestMapping(value = "/provider/{providerId}", method = RequestMethod.GET,headers="Accept=application/json")
    public Schedule getTodaysSchedule(@PathVariable Long providerId) {

        return schedulingService.find(new Provider(providerId), DateTime.now().toDate(), DateTime.now().toDate());
    }
}
