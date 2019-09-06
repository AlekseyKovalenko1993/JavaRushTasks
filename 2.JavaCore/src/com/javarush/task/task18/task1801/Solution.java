package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream reader1 = new FileInputStream(reader.readLine());
        int max = 0;
        while(reader1.available() > 0){
            int b = reader1.read();
            max = Math.max(max,b);
        }
        System.out.println(max);
        reader.close();
        reader1.close();
    }
}
