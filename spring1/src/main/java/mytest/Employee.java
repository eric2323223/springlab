package mytest;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/22/12
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Employee {

    String name;
    int departmentId;
    int band;
    String title;

    public Employee(String name, int departmentId, int band, String title) {
        this.name = name;
        this.departmentId = departmentId;
        this.band = band;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getBand() {
        return band;
    }

    public String getTitle() {
        return title;
    }
}
