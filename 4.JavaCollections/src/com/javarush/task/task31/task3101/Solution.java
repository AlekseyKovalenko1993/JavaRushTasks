package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        File dir = new File(args[0]);
        File result = new File(args[1]);
        File rename = new File(result.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(result,rename);
        ArrayList<File> files = search(dir);
        sortName(files);
        writeResult(files,rename);
    }

    public static ArrayList<File> search(File file){
        ArrayList<File> list = new ArrayList<>();
        for(File f : file.listFiles()){
            if(f.isDirectory()){
                list.addAll(search(f));
            }else if(f.length() <= 50){
                list.add(f);
            }
        }
        return list;
    }

    public static ArrayList<File> sortName(ArrayList<File> list){
        Collections.sort(list, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return list;
    }

    public static void writeResult(ArrayList<File> list, File result) throws IOException {
        try(OutputStream out = new FileOutputStream(result)) {
            for (File file : list) {
                {
                    InputStream in = new FileInputStream(file);
                    while (in.available() > 0) {
                        out.write(in.read());
                    }
                    out.write('\n');
                    in.close();
                }
            }
        }
    }
}
