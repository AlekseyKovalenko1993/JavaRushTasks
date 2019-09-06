package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        StorageStrategy strategy1 = new HashMapStorageStrategy();
        StorageStrategy strategy2 = new OurHashMapStorageStrategy();
        StorageStrategy strategy3 = new FileStorageStrategy();
        StorageStrategy strategy4 = new OurHashBiMapStorageStrategy();
        StorageStrategy strategy5 = new HashBiMapStorageStrategy();
        StorageStrategy strategy6 = new DualHashBidiMapStorageStrategy();
        testStrategy(strategy1,2000);
        testStrategy(strategy2,2000);
        testStrategy(strategy4,2000);
        testStrategy(strategy5,2000);
        testStrategy(strategy6,2000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        HashSet<Long> set = new HashSet<>();
        for(String s : strings){
            set.add(shortener.getId(s));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        HashSet<String> set = new HashSet<>();
        for(Long key : keys){
            set.add(shortener.getString(key));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
        HashSet<String> set = new HashSet<>();
        Shortener shortener = new Shortener(strategy);
        for(int i = 0; i < elementsNumber; i++){
            set.add(Helper.generateRandomString());
        }
        Date startGetIds = new Date();
        Set<Long> keys = getIds(shortener,set);
        Date finishGetIds = new Date();
        Helper.printMessage("Method getIdis  " + (finishGetIds.getTime() - startGetIds.getTime()));
        Date startGetStrings = new Date();
        Set <String> strings = getStrings(shortener,keys);
        Date finishGetStrings = new Date();
        Helper.printMessage("Method getStrings  " + (finishGetStrings.getTime() - startGetStrings.getTime()));
        if(strings.size() == set.size())
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");
    }
}
