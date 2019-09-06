package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    AmigoOutputStream Amigo;

    public QuestionFileOutputStream(AmigoOutputStream Amigo){
        this.Amigo = Amigo;
    }

    @Override
    public void flush() throws IOException {
        Amigo.flush();
    }

    @Override
    public void write(int b) throws IOException {
        Amigo.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        Amigo.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        Amigo.write(b,off,len);
    }

    @Override
    public void close() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String s = reader.readLine();
        if (s.equals("Д")){
            Amigo.close();
        }
    }
}

