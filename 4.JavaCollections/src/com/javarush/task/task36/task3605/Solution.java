package com.javarush.task.task36.task3605;

import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringWriter writer = new StringWriter();
        String line;
        while((line = reader.readLine()) != null){
            writer.write(line);
        }
        TreeSet<Character> set = new TreeSet<>();
        for(char c : writer.toString().toCharArray()){
            if(Character.isLetter(c)){
                set.add(Character.toLowerCase(c));
            }
        }
        if (set.size() < 5) {
            for(char c : set){
                System.out.print(c);
            }
        } else {
            Iterator<Character> iterator = set.iterator();
            for(int i = 0; i < 5; i++){
                System.out.print(iterator.next());
            }
        }
    }
}
