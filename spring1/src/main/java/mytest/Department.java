package mytest;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/22/12
 * Time: 4:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Department {
    int departmentId;
    String departmentName;


    public Department(int id, String name) {
        departmentId = id;
        departmentName = name;
    }


    public String getDepartmentName() {
        return departmentName;
    }

    public int getId() {

        return departmentId;
    }
}
