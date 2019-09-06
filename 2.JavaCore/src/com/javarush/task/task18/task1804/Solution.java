package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream file = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        while(file.available() > 0){
            list.add(file.read());
        }
        reader.close();
        file.close();
        for(int i = 0; i < list.size(); i++){
            int count = 0;
            if(!list1.contains(list.get(i))){
                for(int j = i; j < list.size(); j++){
                    if(list.get(i) == list.get(j)){
                        count++;
                    }
                }
                list1.add(list.get(i));
                list2.add(count);
            }
        }
        int min = Collections.min(list2);
        for(int  i = 0; i < list2.size(); i++){
            if(min == list2.get(i)){
                System.out.print(list1.get(i) + " ");
            }
        }
    }
}
