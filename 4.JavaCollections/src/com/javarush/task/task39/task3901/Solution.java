package com.javarush.task.task39.task3901;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if(s == null || s == "")
            return 0;
       int max = 1;
       char [] mass = s.toCharArray();
       for(int i = 0; i < mass.length ; i++){
           ArrayList<Character> list = new ArrayList<>();
           for(int j = i; j < mass.length; j++){
               if(list.contains(mass[j]))
                   break;
               list.add(mass[j]);
           }
           if(max < list.size())
               max = list.size();
       }
       return max;
    }
}
