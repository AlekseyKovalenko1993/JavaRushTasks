package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
        FileInputStream file = new FileInputStream(new File("dada"));
    }

        public static void main (String[]args){

        }
    }
