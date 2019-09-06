package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            ArrayList<String> l = new ArrayList<>();
            for (int j = 0; j < 3; j++){
                l.add(String.valueOf(j));
            }
            list.add(l);
        }
        ArrayList<String>[] c = list.toArray(new ArrayList[0]);
        return c;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}