package com.xioq.kestral.services.appointments;

import com.xioq.kestral.services.providers.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by bronwen.cassidy on 15/05/2015.
 *
 */
@Configuration
@Service("workingDayService")
@Transactional
public class WorkingDayServiceImpl implements WorkingDayService {

    @Autowired
    private WorkingDayDao dataAccessor;

    public List<WorkingDay> find(Company company, Date startDate, Date endDate) {
        return dataAccessor.find(company, startDate, endDate);
    }
}
