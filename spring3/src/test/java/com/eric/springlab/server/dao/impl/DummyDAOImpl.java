package com.eric.springlab.server.dao.impl;

import org.springframework.stereotype.Repository;

import com.eric.springlab.server.dao.DummyDAO;
import com.eric.springlab.server.entity.DummyEntity;

/**
 * Plain DAO which provides only {@link com.eric.springlab.server.dao.impl.GenericHibernateDAOImpl} methods
 */
@Repository
public class DummyDAOImpl extends GenericHibernateDAOImpl<DummyEntity, Long> implements DummyDAO {
    
}
