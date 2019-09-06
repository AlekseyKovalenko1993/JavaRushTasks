package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Random random = new Random();
        char[] chars = new char[8];
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String number = "1234567890";
        for (int i = 0; i < 3;) {
            int n = random.nextInt(chars.length);
            if(chars[n] == 0){
                switch (i){
                    case 0 : chars[n] = upper.charAt(random.nextInt(upper.length()));
                    break;
                    case 1 : chars[n] = Character.toLowerCase(upper.charAt(random.nextInt(upper.length())));
                    break;
                    case 2 : chars[n] = number.charAt(random.nextInt(number.length()));
                }
                i++;
            }
        }
        for(int i = 0 ; i < chars.length; i++){
            if(chars[i] == 0){
                int choice = random.nextInt(3);
                switch (choice){
                    case 0 : chars[i] = upper.charAt(random.nextInt(upper.length()));
                        break;
                    case 1 : chars[i] = Character.toLowerCase(upper.charAt(random.nextInt(upper.length())));
                        break;
                    case 2 : chars[i] = number.charAt(random.nextInt(number.length()));
                }
            }
        }
        byteArrayOutputStream.write(new String(chars).getBytes());
        return byteArrayOutputStream;
    }
}