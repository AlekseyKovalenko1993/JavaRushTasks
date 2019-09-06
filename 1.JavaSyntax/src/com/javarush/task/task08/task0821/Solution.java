package com.javarush.task.task08.task0821;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Коваленко", "Алексей");
        map.put("Коваленко1", "Алексей");
        map.put("Коваленко2", "Алексей");
        map.put("Коваленко", "Алексей4");
        map.put("Коваленко3", "Алексей3");
        map.put("Коваленко", "Алексей");
        map.put("Коваленко4", "Алексей2");
        map.put("Коваленко1", "Алексей");
        map.put("Коваленко4", "Алексей");
        map.put("Коваленко5", "Алексей");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
