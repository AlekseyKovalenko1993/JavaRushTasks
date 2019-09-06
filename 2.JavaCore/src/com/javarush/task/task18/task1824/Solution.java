package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = null;
        while(true){
            try {
                filename = reader.readLine();
                FileInputStream file = new FileInputStream(filename);
                file.close();
            }catch (FileNotFoundException e){
                System.out.println(filename);
                break;
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
