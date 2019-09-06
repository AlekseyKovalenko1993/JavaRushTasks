package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        HashMap<String, Double> map = new HashMap<>();
        String s = "";
        while(reader.ready()){
            s = reader.readLine();
            if(!map.containsKey(s.split("\\s+")[0])){
                map.put(s.split(" ")[0],Double.parseDouble(s.split(" ")[1]));
            }else{
                map.put(s.split("\\s")[0], Double.parseDouble(s.split("\\s")[1]) + map.get(s.split("\\s")[0]));
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String,Double> pair : map.entrySet()){
            list.add(pair.getKey() + " " + pair.getValue());
        }
        Collections.sort(list);
        for(String s1 : list){
            System.out.println(s1);
        }
        reader.close();
    }
}

