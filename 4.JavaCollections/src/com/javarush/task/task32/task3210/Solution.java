package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;/*
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        RandomAccessFile reader = new RandomAccessFile(args[0],"rw");
        reader.seek(number);
        byte[] buffer = new byte[text.getBytes().length];
        reader.read(buffer,0,text.getBytes().length);
        reader.close();
        reader.seek(reader.length());
        if(new String(buffer).equals(text)){
            reader.write("true".getBytes());
        }else
            reader.write("false".getBytes());
        reader.close();
    }
}
