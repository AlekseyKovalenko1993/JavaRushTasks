package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        HashMap<String,String> addresses = new HashMap<String,String>();
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty())
                break;
            String name = reader.readLine();
            if (name.isEmpty())
                break;
            else
                addresses.put(city,name);
        }
        String key = reader.readLine();
        for (HashMap.Entry<String,String> pairs : addresses.entrySet()){
            if(pairs.getKey().equals(key))
                System.out.println(pairs.getValue());
        }
    }
}
