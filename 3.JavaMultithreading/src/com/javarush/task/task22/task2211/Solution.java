package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(args[0]);
        OutputStream outputStream = new FileOutputStream(args[1]);
        byte[] bufer = new byte[inputStream.available()];
        inputStream.read(bufer);
        String s = new String(bufer,"Windows-1251");
        bufer = s.getBytes("UTF-8");
        outputStream.write(bufer);
        inputStream.close();
        outputStream.close();
    }
}
