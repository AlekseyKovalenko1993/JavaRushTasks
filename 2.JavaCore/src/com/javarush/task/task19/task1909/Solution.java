package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        String s = null;
        reader.close();
        while((s = reader1.readLine()) != null){
            writer.write(s.replaceAll("\\.","\\!")) ;
        }
        reader1.close();
        writer.close();
    }
}
