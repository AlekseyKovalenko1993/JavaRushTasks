package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if(telNumber == null || telNumber.equals(""))
            return false;
        int count = telNumber.replaceAll("\\D","").length();
        if(telNumber.matches("\\+\\d*(\\(\\d{3}\\))?\\d*-?\\d+-?\\d+$") && count == 12)
            return true;
        if(telNumber.matches("\\d*(\\(\\d{3}\\))?\\d*-?\\d+-?\\d+$") && count == 10)
            return true;
        return false;
    }

    public static void main(String[] args) {

    }
}
