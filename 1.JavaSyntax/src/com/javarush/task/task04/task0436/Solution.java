package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (j == b - 1)
                    System.out.println(8);
                else
                    System.out.print(8);
            }
        }
    }
}
