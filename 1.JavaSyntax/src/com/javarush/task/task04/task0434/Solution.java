package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int n = 1;
        int c = 1;
        while (n <= 10) {
            int g = 1;
            while (g <= 10){
                c = n * g;
                if (g == 10)
                    System.out.println(c);
                else
                    System.out.print(c + " ");
                g++;
            }
            n++;
        }

    }
}
