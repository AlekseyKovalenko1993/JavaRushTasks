package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream filereader = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        while(filereader.available() > 0){
            list.add(filereader.read());
        }
        for(int i = 0; i < list.size(); i++){
            if(!list1.contains(list.get(i))){
                list1.add(list.get(i));
            }
        }
        Collections.sort(list1);
        for(int i : list1){
            System.out.print(i + " ");
        }
        filereader.close();
    }
}
