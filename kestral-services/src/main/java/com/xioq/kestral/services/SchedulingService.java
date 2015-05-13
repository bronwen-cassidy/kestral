package com.xioq.kestral.services;

import com.xioq.kestral.model.Company;
import com.xioq.kestral.model.Provider;
import com.xioq.kestral.model.Schedule;
import org.joda.time.DateTime;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface SchedulingService {

    Schedule findTodaysSchedule(Company company);
    Schedule find(Provider provider, DateTime start, DateTime end);
}
