package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mass = new int[15];
        int sum2 = 0;
        int sum1 = 0;
        for (int i = 0; i < mass.length; i++){
            mass[i] = Integer.parseInt(reader.readLine());
            if (i % 2 == 0)
                sum2 += mass[i];
            else
                sum1 += mass[i];
        }
        if (sum1 > sum2)
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else
            System.out.println("В домах с четными номерами проживает больше жителей.");

    }
}
