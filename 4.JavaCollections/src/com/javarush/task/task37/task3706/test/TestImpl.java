package com.javarush.task.task37.task3706.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestImpl {
    public static void main(String[] args) {
        Test test = test2 :: method;
        System.out.println(test.summ(1,2));
        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            list.add(i);
        }
        int result;
        System.out.println(list.stream().filter(a -> a < 3).reduce((x,y) -> x + y).get());
    }

    public static class test2{
        static int method(int a, int b){
            return a+b;
        }
    }
}
