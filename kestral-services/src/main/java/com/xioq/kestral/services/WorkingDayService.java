package com.xioq.kestral.services;

import com.xioq.kestral.model.*;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

/**
 * Created by bronwen.cassidy on 14/05/2015.
 * Service to enable creation, cloning and turning off of working days
 */
@Configuration
public interface WorkingDayService {


    List<WorkingDay> find(Company company, Date startDate, Date endDate);
}
