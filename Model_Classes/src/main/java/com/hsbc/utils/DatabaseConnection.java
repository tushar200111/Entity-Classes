package com.hsbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static Connection conn;
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";


    private static final String LOCAL_DB_URL = "jjdbc:mysql://127.0.0.1:3306/meetingroomdb";
    private static final String LOCAL_USER = "temp";
    private static final String LOCAL_PASS = "";

    public static Connection getLocalConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(LOCAL_DB_URL, LOCAL_USER, LOCAL_PASS);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
