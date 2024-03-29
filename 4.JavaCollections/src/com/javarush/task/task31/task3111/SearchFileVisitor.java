package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize = -1;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        boolean containsPartofName = true;
        if(partOfName != null && !file.getFileName().toString().contains(partOfName))
            containsPartofName = false;
        boolean containsPartofContent = true;
        if(partOfContent != null && !(new String(content).contains(partOfContent)))
            containsPartofContent = false;
        boolean isMax = true;
        if(maxSize != 0 && maxSize < content.length)
            isMax = false;
        boolean isMin = true;
        if(maxSize != -1 && minSize > content.length)
            isMin = false;
        if(containsPartofName && containsPartofContent && isMax && isMin)
            foundFiles.add(file);
        return FileVisitResult.CONTINUE;
    }
}
