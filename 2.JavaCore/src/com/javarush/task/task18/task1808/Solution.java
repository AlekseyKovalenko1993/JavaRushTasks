package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream file1 = new FileInputStream(reader.readLine());
        OutputStream file2 = new FileOutputStream(reader.readLine());
        OutputStream file3 = new FileOutputStream(reader.readLine());
        byte[] buff = new byte[file1.available()];
        int count = file1.read(buff);
        if(count % 2 == 0){
            file2.write(buff,0,count/2);
            file3.write(buff,count/2 , count/2);
        }else{
            file2.write(buff,0,count/2 + 1);
            file3.write(buff,count/2 + 1,count/2);
        }
        file1.close();
        file2.close();
        file3.close();
    }
}
