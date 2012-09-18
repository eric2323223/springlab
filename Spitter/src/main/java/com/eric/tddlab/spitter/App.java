package com.eric.tddlab.spitter;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        try{
            System.out.println("in try block");
        }finally {
            doDB();
            System.out.println("in the end");
        }
    }

    public static void doDB() throws SQLException {
            System.out.println("in finally block");
            throw new SQLException();

    }
}
