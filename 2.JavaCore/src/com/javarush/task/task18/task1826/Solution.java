package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        if(args[0].equals("-e")){
            shifr(args[1],args[2]);
        }else if(args[0].equals("-d")){
            de(args[1],args[2]);
        }
    }
    public static void de(String file1, String file2) throws Exception{
        InputStream inputStream = new FileInputStream(file1);
        OutputStream outputStream = new FileOutputStream(file2);
        while(inputStream.available() > 0){
            int data = inputStream.read();
            outputStream.write(data - 3);
        }
        inputStream.close();
        outputStream.close();

    }

    public static void shifr(String file1, String file2) throws Exception{
        InputStream inputStream = new FileInputStream(file1);
        OutputStream outputStream = new FileOutputStream(file2);
        while(inputStream.available() > 0){
            int data = inputStream.read();
            outputStream.write(data + 3);
        }
        inputStream.close();
        outputStream.close();
    }
}
