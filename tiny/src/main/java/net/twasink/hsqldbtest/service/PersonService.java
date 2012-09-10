package net.twasink.hsqldbtest.service;

import net.twasink.hsqldbtest.dao.PersonDao;
import net.twasink.hsqldbtest.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 9/6/12
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PersonService {
    @Autowired
    PersonDao personDao;

    @Transactional
    public void transferMoney(Person from, Person to, int amount) {
        int balance = from.getMoney();
        from.setMoney(from.getMoney()-amount);
        personDao.update(from);
//        if(amount>balance){
//            throw new MenoyTransferException();
//        }

        if(Math.random()>0.5) {
//            throw new DataAccessException();
        }

        to.setMoney(to.getMoney()+amount);
        personDao.update(to);
    }
}
