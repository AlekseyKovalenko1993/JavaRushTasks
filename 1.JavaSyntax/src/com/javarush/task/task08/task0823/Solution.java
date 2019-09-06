package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        s= s.trim();
        String [] s2 = s.split(" ");
        for(int i = 0; i < s2.length; i++) {
            if (s2[i].equals(""))
                continue;
            else{
                s2[i] = s2[i].trim();
                String first = s2[i].substring(0, 1).toUpperCase();
                s2[i] = first + s2[i].substring(1);
                System.out.print(s2[i]+ " ");
            }
        }
        }
    }
