package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int countp = 0;
        int counto = 0;
        if (a > 0)
            countp++;
        else if (a != 0)
            counto++;
        if (b > 0)
            countp++;
        else if (b != 0)
            counto++;
        if (c > 0)
            countp++;
        else if (c != 0)
            counto++;
        System.out.println("количество отрицательных чисел: " + counto);
        System.out.println("количество положительных чисел: " + countp);
    }
}
