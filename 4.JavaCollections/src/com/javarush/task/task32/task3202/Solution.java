package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if(is == null){
            return writer;
        }
        while (is.available() > 0) {
            byte[] buffer = new byte[1024];
            int data = is.read(buffer);
            writer.write(new String(buffer), 0, data);
        }
        return writer;
    }
}