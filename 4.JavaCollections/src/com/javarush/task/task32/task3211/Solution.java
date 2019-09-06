package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = byteArrayOutputStream.toByteArray();
        md.update(b);
        byte[] mdbytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte e : mdbytes) {

            sb.append(String.format("%02x", e & 0xff));
            System.out.println(sb);
        }

        String digest = sb.toString();
        if (md5.equals(digest))
            return true;
        return false;
    }
}
