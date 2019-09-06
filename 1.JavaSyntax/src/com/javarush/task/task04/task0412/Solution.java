package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        int b = Integer.parseInt(a);
        if (b>0)
            System.out.println(b*2);
        if (b < 0)
            System.out.println(b+1);
        if (b == 0)
            System.out.println(0);
    }

}