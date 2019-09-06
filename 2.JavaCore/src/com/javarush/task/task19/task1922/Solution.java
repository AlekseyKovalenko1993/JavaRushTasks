package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        while (reader1.ready()){
            String s = reader1.readLine();
            int count = 0;
            String[] mass = s.split("\\s");
            for(String str : mass){
                for(String word : words){
                    if(str.equals(word)){
                        count++;
                    }
                }
            }
            if(count == 2){
                System.out.println(s);
            }
        }
        reader.close();
        reader1.close();
    }
}
