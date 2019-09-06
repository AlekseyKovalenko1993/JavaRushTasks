package com.javarush.task.task36.task3612;

import java.util.ArrayList;
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Зима", "осень", "summer", "spring"));
        list.remove(0);
        System.out.println(list.get(0));
    }
}
