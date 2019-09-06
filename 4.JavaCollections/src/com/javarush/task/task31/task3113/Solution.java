package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {
    private static long size;
    private static int countdirectory;
    private static int countfile;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите полный путь файла");
        String name = reader.readLine();
        reader.close();
        Path file = Paths.get(name);
        if(!Files.isDirectory(file)) {
            System.out.println(file.toString() + " - не папка");
            return;
        }
        Files.walkFileTree(file,new Solution());
        print();

    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        countfile++;
        size += Files.size(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        countfile++;
        return FileVisitResult.SKIP_SUBTREE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        countdirectory++;
        return super.preVisitDirectory(dir, attrs);
    }

    public static void print(){
        System.out.println("Всего папок - " + (countdirectory-1));
        System.out.println("Всего файлов - " + countfile);
        System.out.println("Общий размер - " + size);
    }
}
