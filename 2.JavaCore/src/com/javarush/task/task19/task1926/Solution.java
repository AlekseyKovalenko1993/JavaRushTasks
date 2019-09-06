package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        while(reader1.ready()){
            char[] str = reader1.readLine().toCharArray();
            String s = "";
            for(int i = str.length - 1; i >= 0; i--){
                s += str[i];
            }
            System.out.println(s);
        }
        reader.close();
        reader1.close();
    }
}
