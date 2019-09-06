package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        int x = 365;
        int y = 366;
        if (n%4 == 0)
        {
            if(n%100 > 0 )
                System.out.println("количество дней в году: " + y);
            if(n % 100 == 0 && n % 400 == 0)
                System.out.println("количество дней в году: " + y);
            if(n % 100 == 0 && n % 400 !=0)
                System.out.println("количество дней в году: " + x);
        }
        else
            System.out.println("количество дней в году: " + x);
    }
}