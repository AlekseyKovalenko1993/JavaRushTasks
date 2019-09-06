package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream file1 = new FileInputStream(reader.readLine());
        OutputStream file2 = new FileOutputStream(reader.readLine());
        byte [] buff = new byte[file1.available()];
        int data = file1.read(buff);
        for(int i = buff.length - 1 ; i >= 0 ; i--){
            file2.write(buff[i]);
        }
        file1.close();
        file2.close();
        reader.close();
    }
}
