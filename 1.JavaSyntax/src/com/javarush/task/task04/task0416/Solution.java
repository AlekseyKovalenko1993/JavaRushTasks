package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        double a = Double.parseDouble(s);
        a = a % 5;
        if (a <= 2)
            System.out.println("зелёный");
        else if (a < 4)
            System.out.println("жёлтый");
        else
            System.out.println("красный");
    }
}