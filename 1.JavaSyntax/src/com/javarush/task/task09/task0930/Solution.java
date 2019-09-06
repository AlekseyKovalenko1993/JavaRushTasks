package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                numbers.add(Integer.parseInt(array[i]));
                array[i] = null;
            }
        }
        for(int i = 0; i < array.length; i++){
            if(array[i] != null) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] != null) {
                        if (isGreaterThan(array[i], array[j])) {
                            String tmp = array[i];
                            array[i] = array[j];
                            array[j] = tmp;
                        }
                    }
                }
            }
        }
        Integer [] list = numbers.toArray(new Integer [numbers.size()]);
        Arrays.sort(list,Collections.reverseOrder());
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == null){
                array[i] = list[count].toString();
                count++;
            }
            if(count == list.length)
                break;
        }

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') // не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
