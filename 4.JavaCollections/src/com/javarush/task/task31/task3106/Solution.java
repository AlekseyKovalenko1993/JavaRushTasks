package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        List<InputStream> listStream = new Vector<>();
        List<String> listPath = new LinkedList<String>(Arrays.asList(args));
        listPath.remove(0);
        Collections.sort(listPath);
        for(String i : listPath) {
            listStream.add(new FileInputStream(i));
        }
        byte[] contentFile /*= new byte[maxSizeFile]*/;
        try(OutputStream is = new FileOutputStream(args[0]);
            ZipInputStream zip = new ZipInputStream(new SequenceInputStream(Collections.enumeration(listStream)))) {
            for(ZipEntry entry = zip.getNextEntry(); entry != null; ) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                contentFile = new byte[(int)entry.getSize()];
                int count;
                while((count = zip.read(contentFile)) != -1) {
                    baos.write(contentFile, 0, count);
                }
                is.write(baos.toByteArray());
                zip.closeEntry();
                entry = zip.getNextEntry();
            }
        }
    }
}
