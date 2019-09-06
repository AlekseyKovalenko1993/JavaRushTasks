package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(console);
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(result);
        ArrayList<Integer> list = new ArrayList<>();
        while(m.find()){
            list.add(Integer.parseInt(m.group()));
        }
        Pattern p1 = Pattern.compile("[+*-]");
        m = p1.matcher(result);
        String z = "";
        while(m.find()) {
            z = m.group();
        }
        Pattern p2 = Pattern.compile("[^\\n\\r]");
        m = p2.matcher(result);
        String result1 = "";
        while(m.find()){
            result1 += m.group();
        }
        if(z.equals("+")){
            System.out.println(result1 + (list.get(0) + list.get(1)));
        }else if(z.equals("-")){
            System.out.println(result1 + (list.get(0) - list.get(1)));
        }else if(z.equals("*")){
            System.out.println(result1 + (list.get(0) * list.get(1)));
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

