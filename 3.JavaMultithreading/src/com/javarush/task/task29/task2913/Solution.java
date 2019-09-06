package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        if(a < b)
            return increment(a,b);
        else
            return descrement(a,b);
    }

    public static String increment(int a ,int b){
        String line = new String();
        for(int i = a ; i <= b; i++){
            line += i + " ";
        }
        return line.trim();
    }

    public static String descrement(int a ,int b){
        String line = new String();
        for(int i = b; i >= a; i--){
            line += i + " ";
        }
        return line.trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(100);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}