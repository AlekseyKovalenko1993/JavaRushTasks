package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = reader.readLine();
            if(s.equals("exit")){
                break;
            }else{
                new ReadThread(s).start();
            }
        }
        reader.close();
        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try{
                FileInputStream file = new FileInputStream(fileName);
                byte [] buff = new byte[file.available()];
                ArrayList<Character> characters = new ArrayList<>();
                ArrayList<Integer> list = new ArrayList<>();
                file.read(buff);
                for(int i = 0; i < buff.length; i++){
                    if(!characters.contains((char)buff[i])){
                        characters.add((char)buff[i]);
                        list.add(1);
                    }else{
                        int index = characters.indexOf((char)buff[i]);
                        list.set(index,list.get(index) + 1);
                    }
                }
                int max = list.lastIndexOf(Collections.max(list));
                resultMap.put(fileName,(int)characters.get(max));
                file.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


        // implement file reading here - реализуйте чтение из файла тут
    }
}
