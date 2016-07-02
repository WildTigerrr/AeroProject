package com.wildtigerrr.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCreate {

    public static void createDB(boolean drop, boolean create, boolean write, Connection conn) {
        if (drop) {droppingDB(conn);}
        if (create) {creatingDB(conn);}
        if (write) {writingDB(conn);}
    }

    private static void creatingDB(Connection conn) {
        try {
            Statement statement = conn.createStatement();

            String query =
                    "CREATE TABLE FLIGHT (FLIGHTNUMBER VARCHAR(6) PRIMARY KEY, DATE TIMESTAMP, CITY VARCHAR(30), TERMINAL VARCHAR(2), STATUS VARCHAR(12), ARRDEP VARCHAR(10));" +
                            "CREATE TABLE PASSENGER (ID VARCHAR(8) PRIMARY KEY, FLIGHTNUMBER_P VARCHAR(6), NAME VARCHAR(30), SURNAME VARCHAR(50), GENDER VARCHAR(6), DATE_BIRTH DATE, TICKETTYPE VARCHAR(3), FOREIGN KEY(FLIGHTNUMBER_P) REFERENCES FLIGHT(FLIGHTNUMBER));" +
                            "CREATE TABLE TICKET (FLIGHTNUMBER_T VARCHAR(6), BUSPRICE INT, ECOPRICE INT, FOREIGN KEY(FLIGHTNUMBER_T) REFERENCES FLIGHT(FLIGHTNUMBER));";
            statement.execute(query);
            System.out.println("Creating successful.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void droppingDB(Connection conn) {
        try {
            Statement statement = conn.createStatement();

            String query = "DROP TABLE IF EXISTS FLIGHT; DROP TABLE IF EXISTS TICKET; DROP TABLE IF EXISTS PASSENGER;";
            statement.execute(query);
            System.out.println("Dropping successful.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private  static void writingDB(Connection conn) {
            DBWrite.writeAllFlights(conn);
            DBWrite.writeAllPasengers(conn);
            DBWrite.writeAllTickets(conn);
    }

}
