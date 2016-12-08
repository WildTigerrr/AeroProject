package com.wildtigerrr.db;

import com.wildtigerrr.mainlogic.StringOperations;

import java.sql.Connection;

class DBWrite {

    static void writeAllPasengers(Connection conn) {

        for (int i = 0; i <= 2998; i++) {
            String query = StringOperations.getInsertPassString(i);
            DBInteraction.writeInDB(query, conn);
        }
        System.out.println("Writing successful (passengers).");

    }

    static void writeAllFlights(Connection conn) {

        for (int i = 0; i <= 29; i++) {
            String query = StringOperations.getInsertFlightString(i);
            DBInteraction.writeInDB(query, conn);
        }
        System.out.println("Writing successful (flights).");

    }

    static void writeAllTickets(Connection conn) {

        String[] flights = {"GY5177", "PR3684", "NS5385", "NT6585", "LM7377", "NX6470", "SF7643", "EN7856", "NV5551", "FH3612", "IO6748", "SV0124", "OH2707", "HE6248", "TM0471", "EL2721", "BL7123", "NY5402", "TN0478", "AU1850", "ML3380", "EC6864", "KP7046", "HR8844", "DW0845", "YY6655", "WE6313", "VB2665", "UX7321", "NS2166"};
        String flight;
        for (int i = 0; i <= 29; i++) {
            flight = flights[i];
            String query = StringOperations.getInsertTicketsString(flight);
            DBInteraction.writeInDB(query, conn);
        }
        System.out.println("Writing successful (tickets).");

    }

}