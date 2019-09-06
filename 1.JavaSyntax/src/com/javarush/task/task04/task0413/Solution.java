package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String g = reader.readLine();
        int d = Integer.parseInt(g);
        if (d == 1)
            System.out.println("понедельник");
        if (d == 2)
            System.out.println("вторник");
        if (d == 3)
            System.out.println("среда");
        if (d == 4)
            System.out.println("четверг");
        if (d == 5)
            System.out.println("пятница");
        if (d == 6)
            System.out.println("суббота");
        if (d == 7)
            System.out.println("воскресенье");
        if (d<1 || d>7)
            System.out.println("такого дня недели не существует");
    }
}