package com.xioq.kestral.services.appointments;

import com.xioq.kestral.services.DataAccessor;
import com.xioq.kestral.services.providers.Company;

import java.util.Date;
import java.util.List;

/**
 * Created by bronwen.cassidy on 13/05/2015.
 * DataAccessor for custom working day queries
 */
public interface WorkingDayDao extends DataAccessor {


    List<WorkingDay> find(Company company, Date startDate, Date endDate);
}
