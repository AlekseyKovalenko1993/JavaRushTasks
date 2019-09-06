package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream file = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        while (file.available() > 0){
            list.add(file.read());
        }
        file.close();
        reader.close();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int count = 1;
        for(int i = 0;i < list.size() - 1;i++){
            int date = list.get(i);
            count = 1;
            if(!list1.contains(date)){
                for(int j = i + 1; j < list.size(); j++){
                    if(date == list.get(j)){
                        count++;
                    }
                }
                list2.add(count);
                list1.add(date);
            }

        }
        int max = Collections.max(list2);
        for(int i = 0; i < list2.size(); i++){
            if(list2.get(i) == max){
                System.out.print(list1.get(i) + " ");
            }
        }
    }
}
