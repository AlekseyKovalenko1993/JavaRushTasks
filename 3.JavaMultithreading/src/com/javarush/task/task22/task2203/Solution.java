package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null)
            throw new TooShortStringException();
        try{
            String[] mass = string.split("\\t");
            if(mass.length < 3)
                throw new TooShortStringException();
            String s = mass[1];
            return s;
        }catch (ArrayIndexOutOfBoundsException e){
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
