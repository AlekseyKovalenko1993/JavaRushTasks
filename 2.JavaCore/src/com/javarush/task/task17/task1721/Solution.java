package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();


    public static void main(String[] args) throws IOException{
        Solution solution = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader reader2 = new BufferedReader(new FileReader(reader.readLine()));
        for(String line = reader1.readLine(); line != null; line = reader1.readLine()){
            allLines.add(line);
        }
        for(String line = reader2.readLine(); line != null; line = reader2.readLine()){
            forRemoveLines.add(line);
        }
        try {
            solution.joinData();
        }catch (CorruptedDataException e){
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException, IOException {
             for(String s : forRemoveLines){
                 if(allLines.contains(s)){
                     allLines.remove(s);
                 }else {
                     allLines.clear();
                     throw  new CorruptedDataException();
                 }
        }
    }
}
