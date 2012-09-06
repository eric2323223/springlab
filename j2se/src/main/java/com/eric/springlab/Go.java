package com.eric.springlab;

/**
 * Created with IntelliJ IDEA.
 * User: eric
 * Date: 8/30/12
 * Time: 5:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Go {
    public static void main(String[] args) throws ClassNotFoundException {
//        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        Class.forName("org.apache.derby.jdbc.ClientDriver");

    }
}
