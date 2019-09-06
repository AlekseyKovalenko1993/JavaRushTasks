package com.javarush.task.task13.task1319;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.sql.SQLOutput;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));
        while(true){
            String s = reader.readLine();
            writer.write(s);
            writer.write("\n");
            if(s.equals("exit"))
                break;
        }
        writer.close();
        reader.close();
    }
}
