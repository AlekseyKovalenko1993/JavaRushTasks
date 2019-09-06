package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int del = 1;
        int g = 1;
        int count = 0;
        even = 0;
        odd = 0;
        //определяю колличество символов
        while (true) {
            g = a / del;
            if (g < 1)
                break;
            else
                count++;
                del *= 10;
        }
        del = del / 10; // уменьшаю вделитель на 1 ноль, т.к в цикле искал число на порядок выше
        for (int i = 0; i < count; i++) {
            g = a / del;
            del /= 10;
            if (g%2 == 0)
                even++;
            else
                odd++;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}