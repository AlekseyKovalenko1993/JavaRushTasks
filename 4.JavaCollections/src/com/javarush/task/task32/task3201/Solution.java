package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        if(args[0] == null || args[1] == null || args[2] == null){
            System.out.println("Неверные входные данные");
            return;
        }
        String file = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        try {
            RandomAccessFile reader = new RandomAccessFile(file,"wr");
            if((int)reader.length() - 1 > number){
                reader.seek(number);
                reader.write(text.getBytes());
            }else{
                reader.seek(reader.length());
                reader.write(text.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
