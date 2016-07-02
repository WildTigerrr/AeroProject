package com.wildtigerrr.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSingleton {

    private static Connection dbconn;
    private DBConnectionSingleton(){}

    public static synchronized Connection getDBConn () {
        if (dbconn == null) {
            try {
                dbconn = DriverManager.getConnection("jdbc:h2:~/aeroproject", "sa", "");
                System.out.println("Connection to DB successfully created.");
            } catch (SQLException e) {
                System.out.println("Creating connection is failed.");
                e.printStackTrace();
            }
        }

        return dbconn;

    }

}
