package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double summ = 0;
        int count = 0;
        while (true){
            int a = Integer.parseInt(reader.readLine());
            if (a == -1){
                summ /= count;
                System.out.println(summ);
                break;
            }
            else
                count++;
                summ += a;
        }

    }
}

