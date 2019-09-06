package com.javarush.task.task03.task0312;

/* 
Конвертируем время
*/

public class Solution {
    //напишите тут ваш код
    public static int convertToSeconds(int hour){
       int min = hour*60*60;
       return min;
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        int h1=5;
        int h2=6;
        System.out.println(convertToSeconds(h1));
        System.out.println(convertToSeconds(h2));
    }
}
