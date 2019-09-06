package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.put("Коваленко11", 1000);
        map.put("Коваленко10", 10);
        map.put("Коваленко9", 100);
        map.put("Коваленко8", 100);
        map.put("Коваленко7", 2000);
        map.put("Коваленко6", 300);
        map.put("Коваленко5", 4000);
        map.put("Коваленко4", 4000);
        map.put("Коваленко3", 5000);
        map.put("Коваленко2", 1600);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Integer> pair = iterator.next();
            if(pair.getValue() < 500)
                iterator.remove();
        }
    }

    public static void main(String[] args) {

    }
}