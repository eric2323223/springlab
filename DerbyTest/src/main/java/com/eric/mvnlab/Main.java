package com.eric.mvnlab;

import com.eric.mvnlab.dao.VehicleDao;
import com.eric.mvnlab.model.Vehicle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 30.11.11
 * Time: 17:20
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:/META-INF/application-context-root.xml");
//        IRunner runner = ctx.getBean("runner", IRunner.class);
//        runner.run();
//        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

        VehicleDao vehicleDao = (VehicleDao) ctx.getBean("vehicleDao");
//        Vehicle vehicle = new Vehicle("TEM0001", "Red", 4, 4);
//        vehicleDao.insert(vehicle);

        Vehicle vehicle = vehicleDao.findByVehicleNo("TEM0001");
        System.out.println("Vehicle No: " + vehicle.getVehicleNo());
        System.out.println("Color: " + vehicle.getColor());
        System.out.println("Wheel: " + vehicle.getWheel());
        System.out.println("Seat: " + vehicle.getSeat());
    }
}
