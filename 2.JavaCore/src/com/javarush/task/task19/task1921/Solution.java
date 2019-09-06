package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args)throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        SimpleDateFormat format = new SimpleDateFormat("dd M yyyy");
        while(reader.ready()){
            String name = "";
            String date = "";
            String s = reader.readLine();
            Pattern p1 = Pattern.compile("\\D+\\s");
            Matcher m1 = p1.matcher(s);
            while (m1.find()){
                name += m1.group();
            }
            p1 = Pattern.compile("\\d+\\s?");
            m1 = p1.matcher(s);
            while (m1.find()){
                date += m1.group();
            }
            String date1 = date.split("\\s")[0] + " " + (Integer.parseInt(date.split("\\s")[1])) + " " + date.split("\\s")[2];
            PEOPLE.add(new Person(name.trim(), format.parse(date1)));
        }
        reader.close();
    }
}
