package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader1 = new FileReader(reader.readLine());
        reader.close();
        Pattern p = Pattern.compile("world\\s");
        String s = "";
        while(reader1.ready()){
            s += (char) reader1.read();
        }
        Matcher m = p.matcher(s);
        int count = 0;
        while(m.find()){
            count++;
        }
        reader1.close();
        System.out.println(count);
    }
}
