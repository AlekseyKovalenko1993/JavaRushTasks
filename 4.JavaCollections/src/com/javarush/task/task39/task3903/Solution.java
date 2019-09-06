package com.javarush.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Неравноценный обмен
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {
        String numberStr = Long.toBinaryString(number);
        StringBuilder sb = new StringBuilder();
        for(int  g = 0; g < 64 - numberStr.length(); g++){
            sb.append("0");
        }
        sb.append(numberStr);
        char [] chars = sb.toString().toCharArray();
        int size = chars.length - 1;
        char value = chars[size - i];
        chars[size - i] = chars[size - j];
        chars[size - j] = value;
        return Long.parseLong(new String(chars),2);
    }
}
