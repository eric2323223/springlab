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

    public Person getPersonByName(String name){
        return new Person();
    }

}
