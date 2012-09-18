package com.eric.mvnlab.service;

import com.eric.mvnlab.model.Person;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 9/6/12
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PersonService {
    @PersistenceContext
    EntityManager entityManager;

    //    @Transactional(rollbackFor = MyException.class)
    public void createPerson(Person person) {
        entityManager.persist(person);
    }
}
