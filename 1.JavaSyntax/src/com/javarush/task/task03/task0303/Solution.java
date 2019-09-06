package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int eur=5;
        double course=6.0;
        double usd = convertEurToUsd(eur,course);
        System.out.println(usd);
        usd = convertEurToUsd(eur,course);
        System.out.println(usd);
    }
    public static double convertEurToUsd(int eur, double course) {
        //напишите тут ваш код
        double dol =eur*course;
        return dol;
    }
}
