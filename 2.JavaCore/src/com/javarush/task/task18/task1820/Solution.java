package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        FileInputStream file1 = new FileInputStream(filename1);
        FileOutputStream file2 = new FileOutputStream(filename2);
        byte [] buff = new byte[file1.available()];
        int data = file1.read(buff);
        String s = "";
        for(int i = 0; i < buff.length; i++){
            s = s + (char)buff[i];
        }
        String[] mass = s.split(" ");
        for(int i = 0; i < mass.length; i++){
            file2.write((Math.round(Float.parseFloat(mass[i])) + " ").getBytes());
        }
        file2.close();
        file1.close();
    }
}
