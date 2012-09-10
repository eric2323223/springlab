package net.twasink.hsqldbtest.dao;

import net.twasink.hsqldbtest.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 9/5/12
 * Time: 5:30 PM
 * To change this template use File | Settings | File Templates.
 */

public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person> getAllPersons() {
        return  entityManager.createQuery("from Person").getResultList();
    }

    public void update(Person person) {

    }

    public Person getPersonByName(String name) {
        return entityManager.createNamedQuery("Person.findByName", Person.class).setParameter("firstname", name).getSingleResult();
    }

    public Person getPoolest() {
        return entityManager.createNamedQuery("Person.getRichest", Person.class).getResultList().get(0);
    }

}
