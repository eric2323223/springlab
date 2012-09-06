package net.twasink.hsqldbtest.service;

import net.twasink.hsqldbtest.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 9/6/12
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class PersonService {
    @Autowired
    PersonDao personDao;

    public void rename(String origin, String newName) {

    }
}
