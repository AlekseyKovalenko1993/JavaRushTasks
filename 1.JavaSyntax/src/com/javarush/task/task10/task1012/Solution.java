package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        // напишите тут ваш код
        int[] keys = new int[alphabet.size()];
        for (String s : list){
            char[] stroka = s.toCharArray();
            ArrayList<Character> stroka1 = new ArrayList<>();
            for(int i = 0; i < stroka.length;i++){
                stroka1.add(stroka[i]);
            }
            for(char c : stroka1){
                if(alphabet.contains(c)){
                    int m = alphabet.indexOf(c);
                    keys[m] = keys[m] + 1;
                }
            }
        }
        for(int i = 0; i < keys.length; i++){
            System.out.println(alphabet.get(i) + " " + keys[i]);
        }
    }

}
