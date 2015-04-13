package com.xioq.kestral;

import com.xioq.kestral.model.Company;
import com.xioq.kestral.model.Schedule;

public interface SchedulingService {

    Schedule findTodaysSchedule(Company company);
}
