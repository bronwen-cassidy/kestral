package com.xioq.kestral.services.dao;

import com.xioq.kestral.model.Company;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by bronwen.cassidy on 15/04/2015.
 * Geberic data accessor that will connect to the database and implement the findById save and load
 * db methods
 */
@Repository
public interface DataAccessor {

    <T>T findById(Long id, Class<T> clazz);
    <T>List<T> findAll(Class<T> clazz, Company company);
    <T> Serializable save(final T item);
    void delete(final Object object);
    <T> T merge(final T item);
    <T> void saveOrUpdate(final T item);
    <T>List<T> find(Class<T> clazz, Map<String, Object> equalFilters);

    // todo a generic search method??
}
