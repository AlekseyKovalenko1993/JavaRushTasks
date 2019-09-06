package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception{
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        this.load(fileInputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter writer = new PrintWriter(outputStream);
        Properties prop = new Properties();
        for(Map.Entry<String,String> pair : properties.entrySet()){
            prop.setProperty(pair.getKey(), pair.getValue());
        }
        prop.store(writer,null);
        writer.flush();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Properties prop = new Properties();
        prop.load(reader);
        for(String key : prop.stringPropertyNames()){
            properties.put(key , prop.getProperty(key));
        }
    }

    public static void main(String[] args) {

    }
}
