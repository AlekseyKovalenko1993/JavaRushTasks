package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {

    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        while(reader1.ready()){
            for(String s : reader1.readLine().split("\\s")) {
                try{
                    int a = Integer.parseInt(s);
                    if (map.containsKey(a)){
                        System.out.print(map.get(a) + " ");
                    }else
                        System.out.print(s + " ");
                }catch (NumberFormatException e){
                    System.out.print(s + " ");
                    continue;
                }
            }
            System.out.println();
        }
        reader.close();
        reader1.close();
    }
}
