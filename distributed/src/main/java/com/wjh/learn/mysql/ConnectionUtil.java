package com.wjh.learn.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

    private static final String URL = "jdbc:mysql://39.105.93.97:3306/learn";
    private static final String USERNAME = "test";
    private static final String PWD = "123456";
    private static String claaname = "com.mysql.jdbc.Driver";

    public static Connection getConnection() {
        try {
            Class.forName(claaname);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PWD);
            return connection;
        } catch (Exception e) {
            System.out.println("mysql connection failed...");
            e.printStackTrace();
            return null;
        }
    }

}
