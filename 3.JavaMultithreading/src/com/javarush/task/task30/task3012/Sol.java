package com.javarush.task.task30.task3012;

import java.math.BigInteger;

public class Sol {
    public static void main(String[] args) {
        System.out.println(Integer.toString(255, 2));
        BigInteger bigInteger = new BigInteger("255");
        System.out.println(bigInteger.toString(2));

    }
}