package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char [] mass = s.toCharArray();
        ArrayList<Character> sog = new ArrayList<Character>();
        ArrayList<Character> gla = new ArrayList<Character>();
        for(int i = 0; i < mass.length; i++){
            if(isVowel(mass[i])){
                gla.add(mass[i]);
            }
            else if (mass[i] == ' ')
                continue;
            else{
                sog.add(mass[i]);
            }

        }
        for(Character c : gla){
            System.out.print(c + " ");
        }
        System.out.println();
        for (Character c : sog){
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}