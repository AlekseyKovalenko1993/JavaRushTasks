package com.javarush.task.task20.task2025;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.nio.cs.ext.MacArabic;

import java.util.ArrayList;
import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        ArrayList<Long> list = new ArrayList<>();
        for(long i = 0 ; i <= N ; i++){
            long n = (long) Math.log10(i);
            long del = (long) Math.pow(10, n);
            long res = 0;
            long c = 1;
            long x = i;
            if(del == 0){
                list.add(i);
            }else{
                while(del >= 1){
                    c = x / del;
                    x -= c * del;
                    res += Math.pow(c,n + 1);
                    del /= 10;
                }
                if(i == res){
                    list.add(i);
            }
            }
        }
        long[] result = new long[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Date start = new Date();
        long [] mass = getNumbers(100000000);
        Date finish = new Date();
        System.out.println(finish.getTime() - start.getTime());
        for(int i=0;i< mass.length; i ++){
            System.out.println(mass[i]);
        }
    }
}
