package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public  PersonScannerAdapter(Scanner scanner){
            fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String s = fileScanner.nextLine();
            String[] mass = s.split(" +");
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            String d = mass[3] + " " + mass[4] + " " + mass[5];
            try{
                Date date = format.parse(d);
                return new Person(mass[1],mass[2],mass[0],date);
            }catch (ParseException e){
                return null;
            }
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
