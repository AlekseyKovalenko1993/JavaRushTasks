package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        ArrayList<Integer> n = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(Integer.parseInt(reader.readLine()));
            if (i > 0){
                if(list.get(i).equals(list.get(i-1))){
                    count++;
                }
                else{
                    n.add(count + 1);
                    count = 0;
                }
                if(i == 9){
                    n.add(count+1);
                }
            }
        }
        int max = n.get(0);
        for (int i = 1; i < n.size(); i++){
            if(max < n.get(i))
                max = n.get(i);
        }
        System.out.println(max);
    }
}