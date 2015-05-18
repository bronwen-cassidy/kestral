package com.xioq.kestral.controller;

import com.xioq.kestral.model.Provider;
import com.xioq.kestral.model.Schedule;
import com.xioq.kestral.services.DateConstants;
import com.xioq.kestral.services.SchedulingService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by bronwen.cassidy on 18/05/2015.
 */
@RestController
@RequestMapping("/service/schedule/")
public class ScheduleController {

    @Autowired
    private SchedulingService schedulingService;

    @RequestMapping(value = "/provider/{provider_id}/start/{start_date}/end/{end_date}", method = RequestMethod.GET,headers="Accept=application/json")
    public Schedule getSchedule(@PathVariable Long providerId, @PathVariable Date startDate, @PathVariable Date endDate) {

        Schedule schedule = schedulingService.find(new Provider(providerId), startDate, endDate);
        return schedule;
    }

    @RequestMapping(value = "/provider/{provider_id}", method = RequestMethod.GET,headers="Accept=application/json")
    public Schedule getSchedule(@PathVariable Long providerId) {

        Schedule schedule = schedulingService.find(new Provider(providerId), DateTime.now().toDate(), DateTime.now().toDate());
        return schedule;
    }
}
