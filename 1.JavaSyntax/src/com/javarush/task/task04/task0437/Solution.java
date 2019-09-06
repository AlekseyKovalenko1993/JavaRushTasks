package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        for (int i = 1; i <= 10; i++){
            int m = i;
            for (int j = 0; j < m; j++){
                if (j + 1 == m)
                    System.out.println(8);
                else
                    System.out.print(8);
            }
        }

    }
}
