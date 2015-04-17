package com.xioq.kestral.services.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bronwen.cassidy on 15/04/2015.
 * Geberic data accessor that will connect to the database and implement the find save and load
 * db methods
 */
@Repository
public interface DataAccessor {

    <T>T findById(Long id, Class<T> clazz);
    <T>List<T> findAll(Class<T> clazz);
    <T> T save(final T item);
    void delete(final Object object);
    <T> T merge(final T item);
    <T> void saveOrUpdate(final T item);

    // todo a generic search method??
}
