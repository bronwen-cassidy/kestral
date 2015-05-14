package com.xioq.kestral.services.dao;

import com.xioq.kestral.model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bronwen.cassidy on 15/04/2015.
 * Default implementation of common dao methods
 */
@Repository( "dataAccessor" )
@Transactional
public class DataAccessorImpl implements DataAccessor {

    @Autowired
    protected SessionFactory sessionFactory;

    public <T> T findById(Long id, Class<T> clazz) {
        Session currentSession = sessionFactory.getCurrentSession();
        return (T) currentSession.get(clazz, id);
    }

    public <T> List<T> findAll(Class<T> clazz, Company company) {

        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createCriteria(clazz).add(Restrictions.eq("company", company)).list();
    }

    public <T> Serializable save(final T item) {
        return sessionFactory.getCurrentSession().save(item);
    }

    public void delete(final Object object){
        sessionFactory.getCurrentSession().delete(object);
    }

    public <T> T merge(final T item) {
        return (T) sessionFactory.getCurrentSession().merge(item);
    }

    /***/
    public <T> void saveOrUpdate(final T item) {
        sessionFactory.getCurrentSession().saveOrUpdate(item);
    }
}
