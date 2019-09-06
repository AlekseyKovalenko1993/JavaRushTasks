package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int a = Integer.parseInt(reader.readLine());
            if (a <= 0) throw new Exception();
            int b = Integer.parseInt(reader.readLine());
            if(b <= 0) throw new Exception();
            NOK(a,b);
    }
    public static void NOK(int a, int b){
        int n = (a < b) ? a : b;
        for(int i = n; i > 0; i--){
            if (i == 1){
                System.out.println(i);
            }
            else if((a % i == 0) && (b % i == 0)){
                System.out.println(i);
                break;
            }
        }

    }
}
