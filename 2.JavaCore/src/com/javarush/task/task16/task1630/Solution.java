package com.javarush.task.task16.task1630;

import sun.awt.windows.ThemeReader;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        String text = "";
        BufferedReader file;
        @Override
        public void setFileName(String fullFileName) {
            try{
                file = new BufferedReader(new FileReader(fullFileName));
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }

        @Override
        public String getFileContent() {
            return text;
        }

        @Override
        public void run() {
            String a;
            try{
                while((a = file.readLine()) != null){
                    text += a + " ";
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    //add your code here - добавьте код тут
}
