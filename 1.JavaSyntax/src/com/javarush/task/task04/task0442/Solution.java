package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean a = true;
        int summ = 0;
        while (a){
            int x = Integer.parseInt(reader.readLine());
            if (x == -1){
                summ += x;
                System.out.println(summ);
                a = false;
            }
            else
                summ += x;
        }
    }
}
