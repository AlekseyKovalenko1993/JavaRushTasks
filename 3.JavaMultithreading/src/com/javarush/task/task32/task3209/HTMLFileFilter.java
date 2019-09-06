package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        String name = f.getName();
        int a = name.lastIndexOf(".");
        String suff = name.substring(a,name.length());
        if(suff.equalsIgnoreCase(".html") || suff.equalsIgnoreCase(".htm") || f.isDirectory())
            return true;
        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
