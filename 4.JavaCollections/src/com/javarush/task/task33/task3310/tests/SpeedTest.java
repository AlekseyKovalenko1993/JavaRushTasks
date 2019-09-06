package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date start = new Date();
        for(String str : strings){
            ids.add(shortener.getId(str));
        }
        Date finish = new Date();
        return finish.getTime() - start.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date start = new Date();
        for(Long i : ids){
            strings.add(shortener.getString(i));
        }
        Date finish = new Date();
        return finish.getTime() - start.getTime();
    }
    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> originStrings = new HashSet<>();
        for(int i = 0; i < 10000; i++){
            originStrings.add(Helper.generateRandomString());
        }
        HashSet<Long> setKey1 = new HashSet<>();
        HashSet<Long> setKey2= new HashSet<>();
        Long time1 = getTimeToGetIds(shortener1,originStrings,setKey1);
        Long time2 = getTimeToGetIds(shortener2,originStrings,setKey2);
        Assert.assertEquals(time1, time2);
        HashSet<String> getStrings1 = new HashSet<>();
        HashSet<String> getStrings2 = new HashSet<>();
        Long time3 = getTimeToGetStrings(shortener1,setKey1,getStrings1);
        Long time4 = getTimeToGetStrings(shortener2,setKey2,getStrings2);
        Assert.assertEquals(time3,time4,30);
    }
}
