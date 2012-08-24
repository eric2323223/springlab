package mytest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/22/12
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class Service1 {
    @Autowired
    Service2 service;

    @Autowired
    DepartmentDAO departmentDAO;

    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    AccountDAO accountDAO;

    @Autowired
    AccountService accountService;

    public Service1(AccountService accountService) {
        this.accountService = accountService;
    }

    public Service1(){}

    public void printResult(){
        System.out.println(service.getResult());
    }

    public Account getEmployeeAccount(Employee employee)  {
        List<Account> accounts = accountDAO.getAllAccounts();
        for (Account account : accounts) {
            if (account.getAccountOwner().equals(employee.getName())) {
                return account;
            }
        }
        return null;
    }

    public void transfer(Account a, Account b, int amount) throws OverWithdrawException, AccountBannedException {
        accountService.withdraw(a, amount);
        accountService.deposite(b, amount);
    }

    public List<Employee> getDepartmentEmployees(int departmentId) {
        List<Employee> employees = new ArrayList<Employee>();
    for(Employee employee:employeeDAO.getAllEmployee()) {
        if (employee.getDepartmentId() == departmentId) {
            employees.add(employee);
        }
    }
        return employees;
    }

    public Employee getDepartmentHead(int departmentId) {
        int highestBand = 0;
        Employee seniorGuy=null;
        List<Employee> employees = getDepartmentEmployees(departmentId);
        for (Employee employee : employees) {
            if (employee.getBand() > highestBand) {
                highestBand = employee.getBand();
                seniorGuy = employee;
            }
        }
        return seniorGuy;
    }
}
