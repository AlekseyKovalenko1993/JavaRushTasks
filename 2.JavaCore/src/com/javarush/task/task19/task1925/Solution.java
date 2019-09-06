package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        Pattern p = Pattern.compile("[^\\s\\n]{7,}");
        String str = "";
        while(reader.ready()){
            Matcher m = p.matcher(reader.readLine());
            while(m.find()){
               str += (m.group() + ",");
            }
        }
        str = str.substring(0,str.length()-1);
        writer.write(str);
        reader.close();
        writer.close();
    }
}
