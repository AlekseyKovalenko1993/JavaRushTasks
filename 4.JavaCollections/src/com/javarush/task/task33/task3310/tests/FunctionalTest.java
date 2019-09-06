package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class FunctionalTest{
    public void testStorage(Shortener shortener){
        String str1 = Helper.generateRandomString();
        String str2 = Helper.generateRandomString();
        String str3 = new String(str1);
        Long id1 = shortener.getId(str1);
        Long id2 = shortener.getId(str2);
        Long id3 = shortener.getId(str3);
        assertNotEquals(id1,id2);
        assertNotEquals(id3,id2);
        assertEquals(id1,id3);
        String getStr1 = shortener.getString(id1);
        String getStr2 = shortener.getString(id2);
        String getStr3 = shortener.getString(id3);
        assertEquals(str1,getStr1);
        assertEquals(str2,getStr2);
        assertEquals(str3,getStr3);
    }
    @Test
    public void testHashMapStorageStrategy(){
        Shortener shortener =  new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        Shortener shortener =  new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(){
        Shortener shortener =  new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        Shortener shortener =  new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        Shortener shortener =  new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        Shortener shortener =  new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }
}
