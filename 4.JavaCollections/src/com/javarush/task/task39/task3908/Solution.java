package com.javarush.task.task39.task3908;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(isPalindromePermutation(reader.readLine()));
    }

    public static boolean isPalindromePermutation(String s) {
        if(s.length() == 0 || s == null || s.length() == 1)
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            if (map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else
                map.put((char)c,1);
        }
        int count = 0;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue()%2 != 0)
                count++;
        }
        if(count <= 1)
            return true;
        return false;
    }
}
