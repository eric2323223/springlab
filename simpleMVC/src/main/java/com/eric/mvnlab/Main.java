package com.eric.mvnlab;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 9/18/12
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main (String[] args)
    {
        Connection conn = null;

        try
        {
            String userName = "root";
            String password = "sql";
            String url = "jdbc:mysql://9.115.21.74:3306/test";
            Class.forName ("com.mysql.jdbc.Driver").newInstance ();
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println ("Database connection established");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println ("Cannot connect to database server");
        }
        finally
        {
            if (conn != null)
            {
                try
                {
                    conn.close ();
                    System.out.println ("Database connection terminated");
                }
                catch (Exception e) { /* ignore close errors */ }
            }
        }
    }
}
