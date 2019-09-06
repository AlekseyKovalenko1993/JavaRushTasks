package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());
        int[] mass = {a, b, c, d, e};
        for (int i = 0; i < 4; i++) {
            int min = mass[i];
            for (int j = i + 1; j < 5; j++) {
                if (min > mass[j]) {
                    int swap = min;
                    min = mass[j];
                    mass[j] = swap;
                }
                mass[i] = min;
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(mass[i]);
        }
    }
}