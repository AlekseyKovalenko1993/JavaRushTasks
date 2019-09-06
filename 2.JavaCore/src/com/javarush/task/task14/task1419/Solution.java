package com.javarush.task.task14.task1419;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        java.lang.ArithmeticException i1 = new ArithmeticException();
        java.lang.NullPointerException i2 = new NullPointerException();
        java.lang.ArrayIndexOutOfBoundsException i3 = new ArrayIndexOutOfBoundsException();
        java.lang.IndexOutOfBoundsException i4 = new IndexOutOfBoundsException();
        java.lang.NumberFormatException i5 = new NumberFormatException();
        java.io.FileNotFoundException i6 = new FileNotFoundException();
        java.lang.StringIndexOutOfBoundsException i7 = new StringIndexOutOfBoundsException();
        java.lang.NegativeArraySizeException i8 = new NegativeArraySizeException();
        ArrayStoreException i9 = new ArrayStoreException();
        java.lang.ClassCastException i10 = new ClassCastException();
        exceptions.add(i1);
        exceptions.add(i2);
        exceptions.add(i3);
        exceptions.add(i4);
        exceptions.add(i5);
        exceptions.add(i6);
        exceptions.add(i7);
        exceptions.add(i8);
        exceptions.add(i9);
        exceptions.add(i10);

    }
}
