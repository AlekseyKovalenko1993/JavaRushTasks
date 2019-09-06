package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/


import java.util.ArrayList;
import java.util.Arrays;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object object = 5;
        String string = (String) object;
    }

    public void methodThrowsNullPointerException() {
        new ArrayList<String>(Arrays.asList(null)).get(0).toUpperCase();
    }

    public static void main(String[] args) {

    }
}
