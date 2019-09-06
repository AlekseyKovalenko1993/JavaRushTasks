package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int b = number/100;
        number = number - b*100;
        int c = number/10;
        number = number - c*10;
        int a = number + b + c;
        return a;
    }
}