package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset() {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       try{
           String s = reader.readLine();
           if(s.equals("helicopter")){
               result = new Helicopter();
           }else if (s.equals("plane")){
               try{
                   int n = Integer.parseInt(reader.readLine());
                   result = new Plane(n);
               }catch (Exception e){
                   System.out.println("Ощибка при вводе колличства пассажиров");
               }
           }
       }catch (IOException e){
           System.out.println("Ошибка ввода данных");
       }
    }
}
