package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get(args[0]);
        Path zipFile = Paths.get(args[1]);
        Path temp = Files.createTempFile(null,null);
        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile));
             ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(temp))){
            ZipEntry entry = zipInputStream.getNextEntry();
            int count = 0;
            while(entry != null) {
                zipOutputStream.putNextEntry(new ZipEntry(entry.getName()));
                if(Paths.get(entry.getName()).getFileName().equals(file.getFileName())){
                    Files.copy(file,zipOutputStream);
                    count++;
                }else{
                    byte[] buffer = new byte[1024];
                    int data = 0;
                    while((data = zipInputStream.read(buffer)) > 0){
                        zipOutputStream.write(buffer,0,data);
                    }
                }
                zipOutputStream.closeEntry();
                zipInputStream.closeEntry();
                entry = zipInputStream.getNextEntry();
            }
            if(count == 0){
                zipOutputStream.putNextEntry(new ZipEntry("new/" + file.getFileName()));
                Files.copy(file,zipOutputStream);
                zipOutputStream.closeEntry();
            }
        }
        Files.move(temp,zipFile, StandardCopyOption.REPLACE_EXISTING);
    }
}
