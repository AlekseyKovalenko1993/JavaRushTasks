package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine()),"Windows-1251"));
        StringBuilder text = new StringBuilder();
        while (reader1.ready()){
            text.append(reader1.readLine() + " ");
        }
        reader.close();
        reader1.close();
        StringBuilder result = getLine(text.toString().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0)
            return new StringBuilder();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(words));
        Collections.sort(list);
        String result = list.get(0);
        list.remove(0);
        while(list.size() > 0) {
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (result.substring(result.length() - 1).equalsIgnoreCase(list.get(i).substring(0,1))){
                    result += " " + list.get(i);
                    list.remove(i);
                    count++;
                    break;
                }
            }
            if(count == 0){
                result += " " + list.get(0);
                list.remove(0);
            }
        }
        return new StringBuilder(result.trim());
    }
}
