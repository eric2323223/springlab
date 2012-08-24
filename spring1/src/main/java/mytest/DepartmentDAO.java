package mytest;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/22/12
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class DepartmentDAO {


    public List<Department >    getAllDepartment() {

        List<Department>departments = new ArrayList<Department>();
        departments.add(new Department(1, "HR")) ;
        departments.add(new Department(2, "PR")) ;
        departments.add(new Department(3, "AD")) ;
        departments.add(new Department(4, "RD")) ;
        return departments;

    }

    public Department getDepartment(int id) {
        for (Department department : getAllDepartment()) {
            if(department.getId()==id){
                return department;
            }
        }
        return null;
    }
}
