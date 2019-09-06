package com.javarush.task.task07.task0707;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String s1 = "sfs";
        String s2 = "sfs";
        String s3 = "sf12s";
        String s4 = "sfs";
        String s5 = "sf21s";
        list.add(0,s1);
        list.add(1,s2);
        list.add(2,s3);
        list.add(3,s4);
        list.add(4,s5);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
