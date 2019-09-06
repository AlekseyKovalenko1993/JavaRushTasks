package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] mass = new Integer[]{2,5,6,8,9,0};
        sort(mass);
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        double median = getMedian(array);
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs((int)(median - o1)) - Math.abs((int)(median - o2));
            }
        });
        return array;
    }

    public static double getMedian(Integer[] mass){
        Arrays.sort(mass);
        if(mass.length % 2 == 0)
            return (double)((mass[mass.length/2] + mass[mass.length/2 - 1])/2);
        else
            return (double) mass[mass.length/2];

    }
}
