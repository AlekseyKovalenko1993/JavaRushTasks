package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map = new HashMap<>();
        while(true){
            String c = reader.readLine();
            if(c.equals("")){
                break;
            }
            String name = reader.readLine();
             if(name.equals("")){
                int id = Integer.parseInt(c);
                map.put(name, id);
                break;
            }
            else{
                int id = Integer.parseInt(c);
                map.put(name, id);
            }
        }
        for(Map.Entry<String,Integer> pairs : map.entrySet()){
            String name1 = pairs.getKey();
            int d = pairs.getValue();
            System.out.println(d +  " " + name1);
        }

    }
}
