package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.parseInt(reader.readLine());
        if (maximum < 0){
            System.out.println("число меньше 0");
            return;
        }
        //напишите тут ваш код
        int max = 0;
        for (int i = 0; i < maximum;i++){
            int a = Integer.parseInt(reader.readLine());
            if(i == 0)
                max = a;
            if(a > max)
                max = a;
        }

        System.out.println(max);
    }
}
