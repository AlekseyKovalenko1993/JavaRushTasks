package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Belarus");
        map.put("age", null);
        map.put("city", "Minsk");
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
            String result = "";
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value != null) {
                    if (sb.length() > 0) sb.append(" and ");
                    sb.append(key);
                    sb.append(" = '");
                    sb.append(value);
                    sb.append("'");
                }
            }
            return sb.toString();
        }
    }

