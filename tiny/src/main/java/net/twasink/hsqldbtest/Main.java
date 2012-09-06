package net.twasink.hsqldbtest;

import net.twasink.hsqldbtest.dao.PersonDao;
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
        System.out.println(personDao.getAllPersons().get(0).toString());
    }
}
