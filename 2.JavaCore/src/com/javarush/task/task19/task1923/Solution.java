package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
            BufferedReader readerfile = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writerFile = new BufferedWriter(new FileWriter(args[1]));
            Pattern patFindCh = Pattern.compile("\\d");
            Matcher mCh = null;
            Pattern patSt = Pattern.compile("\\w");
            Matcher mSt = null;

            while (readerfile.ready()){
                String[] parsSt = readerfile.readLine().split(" ");

                for (String i : parsSt){
                    mCh = patFindCh.matcher(i);
                    mSt = patSt.matcher(i);
                    if (mCh.find() && mSt.find()){
                        writerFile.write(i + " ");
                    }
                }
            }
            readerfile.close();
            writerFile.close();

        }
    }
