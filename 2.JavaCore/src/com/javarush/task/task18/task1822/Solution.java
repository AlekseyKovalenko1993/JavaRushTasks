package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        File file = new File(s);
        reader.close();
        BufferedReader filereader = new BufferedReader(new FileReader(file));
        String str = "";
        while ((str = filereader.readLine()) != null){
            if(str.split(" ")[0].equals(args[0])){
                System.out.println(str);
                break;
            }
        }
        filereader.close();
    }
}
