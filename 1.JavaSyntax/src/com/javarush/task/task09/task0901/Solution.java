package com.javarush.task.task09.task0901;

/* 
Возвращаем StackTrace
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static StackTraceElement[] method1() {
        method2();
        //напишите тут ваш код
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
        return element;
    }

    public static StackTraceElement[] method2() {
        method3();
        //напишите тут ваш код
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
        return element;
    }

    public static StackTraceElement[] method3() {
        method4();
        //напишите тут ваш код
        StackTraceElement[] element1 = Thread.currentThread().getStackTrace();
        return element1;
    }

    public static StackTraceElement[] method4() {
        method5();
        //напишите тут ваш код
        StackTraceElement[] element2 = Thread.currentThread().getStackTrace();
        return element2;
    }

    public static StackTraceElement[] method5() {
        //напишите тут ваш код
        StackTraceElement[] element2 = Thread.currentThread().getStackTrace();
        return element2;
    }
}
