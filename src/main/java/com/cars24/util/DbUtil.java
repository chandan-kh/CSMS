package com.cars24.util;

import com.cars24.config.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static Connection dbConnection;

    public static Connection getDbConnection(){

        try {
            if(dbConnection==null) {
                 dbConnection = DriverManager.getConnection(DbConfig.host, DbConfig.username, DbConfig.password);
            }
            System.out.println("Connection Successful !!!");
        } catch (SQLException e) {
            System.out.println("Connection failed :( ");
            throw new RuntimeException(e);
        }

        return dbConnection;

    }


}


