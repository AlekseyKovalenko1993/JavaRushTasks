package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("Коваленко","Алексей");
        map.put("Мороз","Анастасия");
        map.put("Зайчик","Петр");
        map.put("Чих","Алексей");
        map.put("Валера","Алексей");
        map.put("Вайшук","Алексей");
        map.put("Яковлев","Алексей");
        map.put("Сидоров","Алексей");
        map.put("Петров","Алексей");
        map.put("Иванов","Александр");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for(Map.Entry<String,String> pairs : map.entrySet()){
            if(pairs.getValue().equals(name)){
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for(Map.Entry<String,String> pairs : map.entrySet()){
            if(pairs.getKey().equals(lastName)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
