package ${package}.server.dao;

import ${package}.server.entity.DummyEntity;

/**
 * Plain DAO which provides only {@link ${package}.server.dao.impl.GenericHibernateDAOImpl} methods
 */
public interface DummyDAO extends GenericDAO<DummyEntity, Long> {
}
