package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream file = new FileInputStream(args[0]);
        byte[] buff = new byte[file.available()];
        int data = file.read(buff);
        ArrayList<Character> characters = new ArrayList<>();
        for(int i = 0; i < buff.length; i++){
            if(!characters.contains((char)buff[i])){
                characters.add((char)buff[i]);
            }
        }
        Collections.sort(characters);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < characters.size(); i++){
            list.add(0);
        }
        for(byte b : buff){
            int index = characters.indexOf((char) b);
            if(index >= 0){
                list.set(index,list.get(index) + 1);
            }
        }
        for(int i = 0; i < characters.size(); i++){
            System.out.println(characters.get(i) + " " + list.get(i));
        }
        file.close();
    }
}
