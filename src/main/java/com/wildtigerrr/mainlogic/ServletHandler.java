package com.wildtigerrr.mainlogic;

import com.wildtigerrr.db.DBConnectionSingleton;
import com.wildtigerrr.db.DBCreate;
import com.wildtigerrr.db.DBInteraction;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

public class ServletHandler {

    public static String mainHandle(HttpServletRequest req) {

        String price = null;
        String flights = null;
        String passengers = null;
        Object priceif = null;
        Object flightsif = null;
        Object passengersif = null;
        String sometext = req.getParameter("sometext");
        String name = req.getParameter("btnname");
        StringOperations.toUTF(sometext);
        String test = null;
        String strRelPath = req.getContextPath();
        String strRealPath = req.getServletContext().getRealPath("");
        System.out.println("Rel path: " + strRelPath);
        System.out.println("Real path: " + strRealPath);
        try {
            switch (name) {
                case "search":
                    passengers = DBInteraction.findPassengers(req);
                    passengersif = "true";
                    break;
                case "rwdb":
                    Connection conn = DBConnectionSingleton.getDBConn();
                    DBCreate.createDB(true, true, true, conn);
                    test = "<script>alert(\"Database recreated\")</script>";
                    break;
                case "price":
                    price = DBInteraction.getPriceList();
                    FilesInteraction.writeInFile(price, strRealPath+"\\price.txt");
                    priceif = "true";
                    break;
                case "flights":
                    flights = null;
                    flightsif = "true";
                    break;
                default:
                    test = "<script>alert(\"Something going wrong\")</script>";
                    break;
            }
        } catch (NullPointerException e) {
            test = "Null pointer";
        }

        if (test == null) test = "";
        if (priceif == null) price = FilesInteraction.getFileInString("price.txt");
        if (flightsif == null) flights = FilesInteraction.getFileInString("flights.txt");
        if (passengersif == null) passengers = FilesInteraction.getFileInString("passengers.txt");
        String head = FilesInteraction.getFileInString("head.txt");
        String bottom = FilesInteraction.getFileInString("bottom.txt");
        String head1 = FilesInteraction.getFileInString("head1.txt");
        String style = FilesInteraction.getFileInString("style.txt");
        String head2 = FilesInteraction.getFileInString("head2.txt");
        return head1 + style + head2 + price + flights + passengers + test + bottom;

    }

}
