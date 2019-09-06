package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String na = bufferedReader.readLine();
        String name = bufferedReader.readLine();
        int n = Integer.parseInt(na);
        System.out.println(name + " захватит мир через " + n + " лет. Му-ха-ха!");
    }
}
