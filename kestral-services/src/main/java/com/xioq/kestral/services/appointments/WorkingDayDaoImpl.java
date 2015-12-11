package com.xioq.kestral.services.appointments;

import com.xioq.kestral.services.providers.Company;
import com.xioq.kestral.services.DataAccessorImpl;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by bronwen.cassidy on 15/05/2015.
 * DataAccessor for custom working day queries
 */
@Repository("workingDayDao")
public class WorkingDayDaoImpl extends DataAccessorImpl implements WorkingDayDao {

    public List<WorkingDay> find(Company company, Date startDate, Date endDate) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createCriteria(WorkingDay.class)
                .add(Restrictions.eq("company", company))
                .add(Restrictions.ge("daysDate", startDate))
                .add(Restrictions.le("daysDate", endDate)).list();
    }
}
