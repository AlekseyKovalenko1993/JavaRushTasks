package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import org.omg.PortableInterceptor.INACTIVE;

import java.io.FileInputStream;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream(args[0]);
        int sum = file.available();
        int count = 0;
        while (file.available() > 0){
            int data = file.read();
            if(data == 32){
                count++;
            }
        }
        file.close();
        float res = (float) ((float)count / sum * 100.0);
        System.out.println(String.format("%.2f",res));
    }
}
