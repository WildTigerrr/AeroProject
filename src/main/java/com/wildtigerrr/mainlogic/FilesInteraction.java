package com.wildtigerrr.mainlogic;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilesInteraction {

    static void writeInFile (String text, String path) {

        String pathOf = path;
        System.out.println("Fin path: " + path);
        try (FileWriter writer = new FileWriter(pathOf, false)) {
            writer.write(text);

            writer.flush();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    public static String getFileInString(String str) {
        String adress = "src/main/webapp/" + str;
        File headFile = new File(adress);
        try{
            FileReader reader = new FileReader(headFile);
            char[] buffer = new char[(int)headFile.length()];
            reader.read(buffer);
            String headStr = new String(buffer);
            return headStr;
        }
        catch (IOException e){return "Failed";}
    }

}
