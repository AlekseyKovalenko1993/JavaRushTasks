package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferOverflowException;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++){
            list.add(reader.readLine());
        }
        int a = list.get(0).length();
        int b = a;
        int c = 0;
        int d = 0;
        for (int i = 1; i < list.size(); i++){
            if (a > list.get(i).length()){
                c = i;
                a = list.get(i).length();
            }
            if (b < list.get(i).length()){
                d = i;
                b = list.get(i).length();
            }
        }
        if (c < d)
            System.out.println(list.get(c));
        else
            System.out.println(list.get(d));
    }
}
