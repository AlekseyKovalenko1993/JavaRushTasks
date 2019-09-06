package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception{
    BufferedReader reader1 = new BufferedReader(new FileReader(args[0]));
    HashMap<String, Double> map = new HashMap<>();
    String s = "";
        while (reader1.ready()) {
            s = reader1.readLine();
            if (!map.containsKey(s.split("\\s+")[0])) {
                map.put(s.split(" ")[0], Double.parseDouble(s.split(" ")[1]));
            } else {
                map.put(s.split("\\s")[0], Double.parseDouble(s.split("\\s")[1]) + map.get(s.split("\\s")[0]));
            }
        }
        ArrayList<Double> list = new ArrayList<>();
        for(Map.Entry<String,Double> pair : map.entrySet()){
            list.add(pair.getValue());
        }
        double max = Collections.max(list);
        for(Map.Entry<String,Double> pair : map.entrySet()){
            if(pair.getValue() == max)
                System.out.println(pair.getKey());
        }
        reader1.close();
    }
}