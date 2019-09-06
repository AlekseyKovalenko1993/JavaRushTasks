package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        InputStream file = new FileInputStream(args[0]);
        int count = 0;
        while(file.available() > 0){
            int data = file.read();
            if((data >=65 && data <= 90) || (data >= 97 && data <= 122)){
                count++;
            }
        }
        System.out.println(count);
        file.close();
    }
}
