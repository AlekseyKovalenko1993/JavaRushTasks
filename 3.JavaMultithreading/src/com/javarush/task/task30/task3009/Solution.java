package com.javarush.task.task30.task3009;

import java.util.LinkedHashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number){
        Integer value = new Integer(0);
        Set<Integer> set = new LinkedHashSet<>();
        try{
            value = Integer.parseInt(number);
        }catch (NumberFormatException e){
            return set;
        }
        for(int i = 2; i <= 36; i++){
            String num = Integer.toString(value,i);
            if(num.equals(new StringBuilder(num).reverse().toString())){
                set.add(i);
            }
        }
        return set;
    }
}