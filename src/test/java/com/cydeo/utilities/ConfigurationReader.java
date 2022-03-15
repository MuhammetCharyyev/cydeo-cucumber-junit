package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1. create the object of Properties
    private static Properties properties = new Properties();
    //make it 'private' to be not accessible and 'static' to run it first

    static {

        try {
            //2. we need to open the file in Java memory; FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");
            //get the name in "configuration.properties" and put in parentheses

//3. load the properties object using FileInputStream object
            properties.load(file);
            // 'load' is exception like FileInputStream, 'load' is a parent class
            //try/catch as dealing with exception

            //close the file
            file.close();//when it is not in use the file will be closed

        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader class.");
            e.printStackTrace();
        }
//loading the properties of the "configuration.properties" file

    }

   public static String getProperty(String keyword){
        //whenever calling this method it will come to the file configuration.properties with
        //calling of all properties over there and all the code logic above
        return properties.getProperty(keyword);
    }



}
