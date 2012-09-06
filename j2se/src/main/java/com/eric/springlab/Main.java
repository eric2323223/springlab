package com.eric.springlab;

import java.sql.*;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: xaoc
 * Date: 30.11.11
 * Time: 17:20
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
//				"classpath:/META-INF/application-context-root.xml");
////        IRunner runner = ctx.getBean("runner", IRunner.class);
////        runner.run();
//        VehicleDao vehicleDao = (VehicleDao) ctx.getBean("vehicleDao");
//        Vehicle vehicle = new Vehicle("TEM0001", "Red", 4, 4);
//        vehicleDao.insert(vehicle);
//        vehicle = vehicleDao.findByVehicleNo("TEM0001");
//        System.out.println("Vehicle No: " + vehicle.getVehicleNo());
//        System.out.println("Color: " + vehicle.getColor());
//        System.out.println("Wheel: " + vehicle.getWheel());
//        System.out.println("Seat: " + vehicle.getSeat());

        showTableContents();
    }

    private final static String DB_URL = "jdbc:derby:C:\\cygwin\\home\\eric\\workspace\\j2se\\myDB";
    private final static String DERBY_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";

    public static void showTableContents() {
        Connection conn = null;
        try {
            Class.forName(DERBY_DRIVER);
            Properties properties = new Properties();
            properties.put("create", "false"); // 新建数据库
            properties.put("user", "app");     // 用户名
            properties.put("password", "app"); // 密码

            // properties.put("retreiveMessagesFromServerOnGetMessage", "true");
            conn = DriverManager.getConnection(DB_URL, properties);

            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM vehicle");

            while (result.next()) {
                System.out.println("序号 : " + result.getInt(1));
            }
            result.close();
            stat.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
