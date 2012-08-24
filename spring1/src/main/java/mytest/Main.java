package mytest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/22/12
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) throws OverWithdrawException, AccountBannedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Service1 service = (Service1)context.getBean("service1");
        Employee rdManager = service.getDepartmentHead(4);
        Employee hrManager = service.getDepartmentHead(1);

        Account accountA = service.getEmployeeAccount(rdManager);
        Account accountB = service.getEmployeeAccount(hrManager);
        service.transfer(accountA, accountB, 50);

        System.out.println(accountA.getBalance());
        System.out.println(accountB.getBalance());

        System.out.println(service.getDepartmentHead(4).getName());
    }
}
