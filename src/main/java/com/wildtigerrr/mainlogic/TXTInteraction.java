package com.wildtigerrr.mainlogic;

import java.io.FileReader;
import java.io.IOException;

public class TXTInteraction {

    public static String getPassStrings(int a) {

        String string;

        try {
            FileReader reader = new FileReader("names.txt");
            reader.read();
            char c = 0;
            TXTInteraction.skipStrings(reader, a);
            string = "";
            while (c != '\n') {
                c = (char) reader.read();
                string = string + c;
            }
            return string;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to get passenger string.";
        }

    }

    public static String getFlightStrings(int i) {
        String string;

        try {
            FileReader reader = new FileReader("flights.txt");
            char c = 0;
            TXTInteraction.skipStrings(reader, i);
            string = "";
            while (c != '\n') {
                c = (char) reader.read();
                string = string + c;
            }
            return string;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to get flight string";
        }
    }



    /*Method for skipping strings*/
    public static void skipStrings(FileReader reader, int skip /*Number of strings to skip*/) {
        for (int l = 0; l < skip; l++){
            char c = 0;
            while (c != '\n') {
                try {
                    c = (char) reader.read();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    } /*End of skipping strings method*/

}
