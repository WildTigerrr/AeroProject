package com.wildtigerrr.db;

import com.wildtigerrr.mainlogic.StringOperations;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInteraction {

    static void writeInDB(String query, Connection conn){

        try {
            Statement statement = conn.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("Write failed.");
            e.printStackTrace();
        }

    }

    private static ResultSet findInDB(String query, Connection conn) {

        try {
            Statement statement = conn.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String findPassengers (HttpServletRequest req) {
        String name = req.getParameter("name");
        name = StringOperations.toUTF(name);
        String surname = req.getParameter("surname");
        surname = StringOperations.toUTF(surname);
        String ID = req.getParameter("ID");
        ID = StringOperations.toUTF(ID);
        String gender;
        String birth;
        String ticket;
        String flight = req.getParameter("flight");
        String date = req.getParameter("date");
        String city = req.getParameter("city");
        String bus;
        String eco;

        String query = "SELECT NAME, SURNAME, ID, GENDER, DATE_BIRTH, TICKETTYPE, FLIGHTNUMBER, DATE, CITY, BUSPRICE, ECOPRICE \n" +
                "FROM PASSENGER, FLIGHT, TICKET\n" +
                "WHERE FLIGHTNUMBER = FLIGHTNUMBER_P AND FLIGHTNUMBER = FLIGHTNUMBER_T";
        if (!ID.equals("")) query = query + " AND ID='" + ID + "'";
        if (!name.equals("")) query = query + " AND NAME='" + name + "'";
        if (!surname.equals("")) query = query + " AND SURNAME='" + surname + "'";
        if (!flight.equals("")) query = query + " AND FLIGHTNUMBER='" + flight + "'";
        if (!city.equals("")) query = query + " AND CITY='" + city + "'";
        if (!date.equals("")) query = query + " AND DATE='" + date + "'";
        query = query + ";";

        Connection conn = DBConnectionSingleton.getDBConn();
        ResultSet rs = findInDB(query, conn);
        String result = "<div><table nowrap;>" +
                "<tr><td><b>Name</b></td><td><b>Surname</b></td><td><b>ID</b></td><td><b>Gender</b></td><td><b>Birth</b></td>"
                + "<td><b>Flight</b></td><td><b>Date</b></td><td><b>City</b></td><td><b>Price</b></td></tr>";

        try {
            while (rs.next()){
                name = rs.getString("NAME");
                surname = rs.getString("SURNAME");
                ID = rs.getString("ID");
                gender = rs.getString("GENDER");
                birth = rs.getString("DATE_BIRTH");
                ticket = rs.getString("TICKETTYPE");
                flight = rs.getString("FLIGHTNUMBER");
                date = rs.getString("DATE");
                city = rs.getString("CITY");
                bus = rs.getString("BUSPRICE");
                eco = rs.getString("ECOPRICE");
                String price;
                if (ticket.equals("BUS")) {price = bus;} else {price = eco;}

                result = result + "<tr><td>" + name + "</td><td>" + surname + "</td><td>" +
                        ID + "</td><td>" + gender + "</td><td>" +
                        birth + "</td><td>" + flight + "</td><td>" + date + "</td><td>" +
                        city + "</td><td>" + price + "</td></tr>";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        result = result + "</table></div>";
        return result;

    }

    public static String getPriceList() {

        String query = "SELECT FLIGHTNUMBER, CITY, DATE, ECOPRICE, BUSPRICE \n" +
                "FROM FLIGHT, TICKET \n" +
                "WHERE FLIGHTNUMBER = FLIGHTNUMBER_T;";

        Connection conn = DBConnectionSingleton.getDBConn();
        ResultSet rs = DBInteraction.findInDB(query, conn);

        String flight = null;
        String city = null;
        String date = null;
        String eco = null;
        String bus = null;
        String result = "<div><table nowrap;>" +
                "<tr><td><b>Flight</b></td><td><b>City</b></td><td><b>Date</b></td><td><b>Econom price</b></td><td><b>Business price</b></td>";

        try {
            while (rs.next()) {
                flight = rs.getString("FLIGHTNUMBER");
                city = rs.getString("CITY");
                date = rs.getString("DATE");
                eco = rs.getString("ECOPRICE");
                bus = rs.getString("BUSPRICE");

                result = result + "<tr><td>" + flight + "</td><td>" + city + "</td><td>" + date + "</td><td>" + eco + "</td><td>" + bus + "</td></tr>";
            }
        } catch (SQLException e) {return null;}

        result = result + "</table></div>";
        return result;

    }

}
