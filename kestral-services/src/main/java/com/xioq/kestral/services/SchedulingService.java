package com.xioq.kestral.services;

import com.xioq.kestral.model.Client;
import com.xioq.kestral.model.Company;
import com.xioq.kestral.model.Provider;
import com.xioq.kestral.model.Schedule;
import org.joda.time.DateTime;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public interface SchedulingService {

    Schedule findTodaysSchedule(Company company);
    Schedule find(Provider provider, Date start, Date end);
    Schedule find(Client client, Date start, Date end);
}
