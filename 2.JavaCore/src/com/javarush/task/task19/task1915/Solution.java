package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream writer = new FileOutputStream(reader.readLine());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        writer.write(outputStream.toByteArray());
        System.setOut(console);
        System.out.println(result);
        writer.close();
        reader.close();
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

