package com.javarush.task.task15.task1519;

import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while(true){
            String s = reader.readLine();
            if(s.equals("exit")){
                break;
            }else{
                list.add(s);
            }
        }
        for(int i = 0; i < list.size(); i++){
           if(list.get(i).contains(".")){
               try{
                   Double d = Double.parseDouble(list.get(i));
                   print(d);
               }catch (Exception e){
                   print(list.get(i));
               }
           }
           else
               try{
                   Integer a = Integer.parseInt(list.get(i));
                   if(a < 128 && a > 0){
                       short b = (short)((int)a);
                       print(b);
                   }
                   else
                       print(a);
               }catch (Exception e){
                   print(list.get(i));
               }
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
