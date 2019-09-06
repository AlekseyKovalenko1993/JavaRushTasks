package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(2.2,"ada");
        labels.put(2.1,"ada");
        labels.put(2.0,"ada");
        labels.put(2.5,"ada");
        labels.put(2.4,"ada");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
