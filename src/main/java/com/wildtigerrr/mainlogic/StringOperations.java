package com.wildtigerrr.mainlogic;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.StringTokenizer;

public class StringOperations {



    public static String toUTF(String str) {
        String someUTF;
        try {
            someUTF = new String(str.getBytes("ISO-8859-1"), "UTF-8");
            return someUTF;
        } catch (UnsupportedEncodingException e) {
            return "Failed to encode.";
        } catch (NullPointerException e) {
            return "Here is NullPointerException";
        }
    }

    public static String getSerial() {
        char[] arr = {'С', 'Н', 'К', 'В', 'Т', 'М'};
        String ser = "";
        Random r = new Random();
        for (int i = 0; i <= 1; i++){
            ser = ser + String.valueOf(arr[r.nextInt(arr.length)]);
        }
        return ser;
    }

    public static String strToDateString(String dating){
        StringTokenizer st = new StringTokenizer(dating, ".");
        int month = Integer.parseInt((String) st.nextElement());
        int date = Integer.parseInt((String) st.nextElement());
        int year = Integer.parseInt((String) st.nextElement());
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, date);
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        return df.format(calendar.getTime());
    }

    public static String getInsertPassString(int i){

        String[] flights = {"GY5177", "PR3684", "NS5385", "NT6585", "LM7377", "NX6470", "SF7643", "EN7856", "NV5551", "FH3612", "IO6748", "SV0124", "OH2707", "HE6248", "TM0471", "EL2721", "BL7123", "NY5402", "TN0478", "AU1850", "ML3380", "EC6864", "KP7046", "HR8844", "DW0845", "YY6655", "WE6313", "VB2665", "UX7321", "NS2166"};
        String flightnum = null;
        Random r = new Random();
        for (int j = 0; j <= 1; j++){
            flightnum = flights[r.nextInt(flights.length)];
        }
        String[] tickets = {"BUS", "ECO"};
        String tickettype = tickets[r.nextInt(tickets.length)];
        String string = TXTInteraction.getPassStrings(i);
        StringTokenizer st = new StringTokenizer(string);
        String gender = (String) st.nextElement();
        gender = gender.toUpperCase();
        String name = (String) st.nextElement();
        String surname = (String) st.nextElement();
        String date = (String) st.nextElement();
        String calendar = StringOperations.strToDateString(date);
        String ID = (String) st.nextElement();
        String serial = StringOperations.getSerial() + ID.substring(0,6);

        String insert = "INSERT INTO PASSENGER VALUES(\'" + serial +
                "\', \'" + flightnum +
                "\', \'" + name +
                "\', \'" + surname +
                "\', \'" + gender +
                "\', \'" + calendar +
                "\', \'" + tickettype +
                "\');";
        return insert;
    }

    public static String getInsertFlightString(int i){

        String string = TXTInteraction.getFlightStrings(i);
        StringTokenizer st = new StringTokenizer(string);
        String flight = (String) st.nextElement();
        String date = (String) st.nextElement() + " " + st.nextElement();
        String city = (String) st.nextElement();
        city = city.toUpperCase();
        String terminal = (String) st.nextElement();
        String status = (String) st.nextElement();
        String arrdep = (String) st.nextElement();

        String insert = "INSERT INTO FLIGHT VALUES(\'" + flight +
                "\', \'" + date +
                "\', \'" + city +
                "\', \'" + terminal +
                "\', \'" + status +
                "\', \'" + arrdep +
                "\');";
        return insert;
    }

    public static String getInsertTicketsString(String flight){

        Random r = new Random();
        int ecoprice = 30 + r.nextInt(50);
        int busprice = ecoprice + 30 + r.nextInt(70);
        ecoprice = ecoprice * 10;
        busprice = busprice * 10;
        String insert = "INSERT INTO TICKET VALUES(\'" + flight +
                "\', " + busprice +
                ", " + ecoprice +
                ");";
        return insert;

    }

}
