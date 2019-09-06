package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> namefiles = new ArrayList<>();
        String name;
        while (!(name = reader.readLine()).equals("end")) {
            namefiles.add(name);
        }
        reader.close();
        Collections.sort(namefiles);
        String filename = namefiles.get(0).split(".part")[0];
        FileOutputStream fileOutputStream = new FileOutputStream(filename, true);
        for(String s : namefiles){
            FileInputStream file = new FileInputStream(s);
            byte[] buff = new byte[file.available()];
            file.read(buff);
            fileOutputStream.write(buff,0,buff.length);
            file.close();
        }
        fileOutputStream.close();
    }
}
