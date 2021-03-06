package net.twasink.hsqldbtest;

import net.twasink.hsqldbtest.dao.PersonDao;
import net.twasink.hsqldbtest.model.Person;
import net.twasink.hsqldbtest.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 9/6/12
 * Time: 9:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonDao personDao = (PersonDao) context.getBean("personDao");
        Person eric = personDao.getPersonByName("peng");
        Person mark = personDao.getPersonByName("ma");
//        System.out.println(personDao.getAllPersons().get(0).toString());
//        System.out.println(personDao.getPersonByName("peng"));
//        System.out.println(personDao.getPoolest());
        PersonService personService = (PersonService) context.getBean("personService");
        personService.transferMoney(mark, eric, 50);
        System.out.println(mark);
        System.out.println(eric);

//        personService.sayHello();
    }
}
