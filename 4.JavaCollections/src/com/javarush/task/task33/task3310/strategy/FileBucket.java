package com.javarush.task.task33.task3310.strategy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    Path path;

    public FileBucket() throws IOException {
        path = Files.createTempFile(null, null);
        Files.deleteIfExists(path);
        Files.createFile(path);
        path.toFile() .deleteOnExit();
    }
     public long getFileSize() throws IOException{
        return Files.size(path);
     }

     public void putEntry(Entry entry) throws IOException {
         ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path));
         out.writeObject(entry);
         out.close();
     }

     public  Entry getEntry() throws IOException,ClassNotFoundException{
        if(getFileSize() == 0)
            return null;
         ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path));
         Entry entry = (Entry) in.readObject();
         in.close();
         return entry;
    }

     public void remove() throws IOException{
        Files.delete(path);
     }

}

