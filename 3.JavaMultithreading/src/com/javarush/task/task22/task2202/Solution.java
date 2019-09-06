package com.javarush.task.task22.task2202;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if(string == null)
            throw new TooShortStringException();
        try{
            String[] mass = string.split(" ");
            StringBuilder str = new StringBuilder();
            for(int i = 1; i < 5; i++){
                str.append(mass[i] + " ");
            }
            return str.toString().trim();
        }catch (ArrayIndexOutOfBoundsException e){
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
