package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException  {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStreamr = new FileInputStream(reader.readLine());
        while(inputStreamr.available() > 0){
            int data = inputStreamr.read();
            System.out.print((char) data);
        }
        reader.close();
        inputStreamr.close();
    }
}