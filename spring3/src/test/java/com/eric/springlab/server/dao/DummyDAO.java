package com.eric.springlab.server.dao;

import com.eric.springlab.server.entity.DummyEntity;

/**
 * Plain DAO which provides only {@link com.eric.springlab.server.dao.impl.GenericHibernateDAOImpl} methods
 */
public interface DummyDAO extends GenericDAO<DummyEntity, Long> {
}
