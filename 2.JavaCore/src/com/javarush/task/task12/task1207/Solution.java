package com.javarush.task.task12.task1207;

/* 
Int и Integer
*/

public class Solution {
    public static void main(String[] args) {
        print(new Integer(3));
        print((int) 3);


    }

    //Напишите тут ваши методы
    public static void print(Integer a){
        System.out.println(a);
    }

    public static void  print(int a){
        System.out.println(a);
    }
}
