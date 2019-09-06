package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File dir = new File(root);
        ArrayList<String> list = new ArrayList<>();
        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.add(dir);
        while (!queue.isEmpty()) {
            File file = queue.pop();
            for(File f : file.listFiles()){
                if(f.isDirectory()){
                    queue.add(f);
                }else {
                    list.add(f.getAbsolutePath());
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        
    }
}
