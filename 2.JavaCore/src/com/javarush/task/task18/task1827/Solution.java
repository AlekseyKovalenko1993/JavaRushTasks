package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if(args.length != 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            reader.close();
            BufferedReader reader1 = new BufferedReader(new FileReader(name));
            OutputStream filewriter = new FileOutputStream(name, true);
            int max = 0;
            String stroka = null;
            while ((stroka = reader1.readLine()) != null) {
                String s = stroka.substring(0, 8);
                s = s.trim();
                int a = Integer.parseInt(s);
                if (a > max)
                    max = a;
            }
            String id = retuner(Integer.toString(max + 1), 8);
            String productName = retuner(args[1], 30);
            String price = retuner(args[2], 8);
            String quantity = retuner(args[3], 4);
            String infa = "\n" + id + productName + price + quantity;
            filewriter.write(infa.getBytes());
            reader1.close();
            filewriter.close();
        }else
            return;
    }
    public static String retuner(String s,int n){
        String retuner = "";
        char[] chars = s.toCharArray();
        for(int i = 0; i < n; i++){
            if(chars.length - 1 >= i){
                retuner += chars[i];
            }else
                retuner += " ";
        }
        return retuner;
    }
}
