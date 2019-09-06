package com.javarush.task.task37.task3714;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        for(char c : s.toUpperCase().toCharArray()){
            list.add(convet(c));
        }
        if(list.size() == 1)
            return list.get(0);
        int result = list.get(list.size() - 1);
        for(int i = list.size() - 2; i >= 0; i--){
            if(list.get(i) >= list.get(i + 1))
                result += list.get(i);
            else
                result -= list.get(i);
        }
        return result;
    }

    public static int convet(char c){
        switch (c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: throw new IllegalArgumentException("хуйня");
        }
    }
}
