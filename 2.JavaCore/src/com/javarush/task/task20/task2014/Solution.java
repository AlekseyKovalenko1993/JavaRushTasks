package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws Exception{
        Solution savedObject = new Solution(4);
        FileOutputStream out = new FileOutputStream("C:\\Users\\Алексей\\Desktop\\тест\\1.txt");
        ObjectOutputStream ob = new ObjectOutputStream(out);
        ob.writeObject(savedObject);
        out.close();
        ob.close();
        System.out.println(savedObject);
        FileInputStream in = new FileInputStream("C:\\Users\\Алексей\\Desktop\\тест\\1.txt");
        ObjectInputStream obin = new ObjectInputStream(in);
        Solution loadObject = (Solution) obin.readObject();
        System.out.println(loadObject);
        in.close();
        obin.close();
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
