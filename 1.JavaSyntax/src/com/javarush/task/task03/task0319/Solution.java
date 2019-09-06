package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String name = bufferedReader.readLine();
        String zp = bufferedReader.readLine();
        String l = bufferedReader.readLine();
        int z = Integer.parseInt(zp);
        int let = Integer.parseInt(l);
        System.out.println(name + " получает " + z + " через " + let + " лет.");
    }
}
