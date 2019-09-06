package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();
        Pattern p = Pattern.compile("[\\w+\\s]");
        while(reader1.ready()){
            String s = reader1.readLine();
            Matcher m = p.matcher(s);
            while(m.find()){
                writer.write(m.group());
            }
        }
        reader1.close();
        writer.close();
    }
}
