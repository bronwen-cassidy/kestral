package com.xioq.kestral.services.appointments;

import com.xioq.kestral.services.clients.Client;
import com.xioq.kestral.services.providers.Provider;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public interface SchedulingService {

    Schedule findTodaysSchedule(Provider provider);
    Schedule find(Provider provider, Date start, Date end);
    Schedule find(Client client, Date start, Date end);
}
