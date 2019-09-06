package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        String filename1 = reader.readLine();
        InputStream  file1 = new FileInputStream(filename);
        InputStream file2 = new FileInputStream(filename1);
        byte [] buff1 = new byte[file1.available()];
        byte [] buff2 = new byte[file2.available()];
        int data1 = file1.read(buff1);
        int data2 = file2.read(buff2);
        file1.close();
        OutputStream outputStream = new FileOutputStream(filename);
        outputStream.write(buff2);
        outputStream.write(buff1);
        outputStream.close();
        file2.close();
    }
}
