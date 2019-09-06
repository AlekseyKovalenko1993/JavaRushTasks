package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1[];
        int n = 0;
        try {
            String s = reader.readLine();
            s = s.split("\\?")[1];
            s1 = s.split("&");
            for (int i = 0; i < s1.length; i++) {
                    System.out.print(s1[i].split("=")[0] + " ");
            }
            System.out.println();
            for(String a : s1){
                if(a.contains("obj")) {
                    try {
                        double d = Double.parseDouble(s1[n].split("=")[1]);
                        alert(d);
                    } catch (Exception e) {
                        alert(s1[n].split("=")[1]);
                    }
                }
            }
        }catch (IOException ex){
            System.out.println("Ошибка");
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
