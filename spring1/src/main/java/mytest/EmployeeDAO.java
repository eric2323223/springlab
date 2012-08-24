package mytest;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/22/12
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class EmployeeDAO {

    public List<Employee>  getAllEmployee() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Eric", 4, 7, "staff engineer"));
        employees.add(new Employee("stt", 4, 7, "staff engineer"));
        employees.add(new Employee("Carol", 1, 6, "representative"));
        employees.add(new Employee("Jim", 4, 8, "manager"));
        employees.add(new Employee("Jason", 1, 8, "manager"));
        return employees;
    }

    public Employee getEmployeeByName(String name) {
        for (Employee employee : getAllEmployee()) {
            if (employee.getName().equals(name)) {
                return employee;
            }

        }
        return null;
    }
}
