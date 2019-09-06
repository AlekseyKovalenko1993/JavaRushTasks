package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter writer =  new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();
        String s = "";
        while(reader1.ready()){
            s += (char) reader1.read();
        }
        String[] mass = s.split("\\s");
        for(String str : mass){
           try{
               int a = Integer.parseInt(str);
               writer.write(str + " ");
           }catch (NumberFormatException e){
               continue;
           }
        }
        reader1.close();
        writer.close();
    }
}
