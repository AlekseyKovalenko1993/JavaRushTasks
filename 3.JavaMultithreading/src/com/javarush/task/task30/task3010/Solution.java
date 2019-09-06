package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            String s = args[0];
            if(s.length() > 255){
                System.out.println("length is over than 255");
                return;
            }
            if(s.isEmpty()){
                System.out.println("line is empty");
                return;
            }
            char[] mass = s.toCharArray();
            int radix = 2;
            for(int i = 0; i < mass.length; i++){
                int value;
                if(mass[i] >= 48 && mass[i] <= 57){
                    value = mass[i] - 48 + 1;
                    radix = swap(radix, value);
                }else if(mass[i] >= 65 && mass[i] <= 90){
                    value = mass[i] - 65 + 11;
                    radix = swap(radix, value);

                }else if(mass[i] >= 97 && mass[i] < 122){
                    value = mass[i] - 97 + 11;
                    radix = swap(radix, value);
                }else {
                    System.out.println("incorrect");
                    return;
                }

            }
            System.out.println(radix);
        } catch (Exception e) {
            return;
        }
    }

    private static int swap(int radix, int value) {
        if (value > radix)
            radix = value;
        return radix;
    }

}