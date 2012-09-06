package com.eric.appfuselab.dao;

import com.eric.appfuselab.model.Car;
import org.apache.xmlbeans.impl.piccolo.xml.EntityManager;

import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 9/3/12
 * Time: 5:38 PM
 * To change this template use File | Settings | File Templates.
 */
//@Repository
public class CarDao {
    @PersistenceContext
    EntityManager entityManager;

    public List<Car> getAllCars(){
        return null;
    }
}
