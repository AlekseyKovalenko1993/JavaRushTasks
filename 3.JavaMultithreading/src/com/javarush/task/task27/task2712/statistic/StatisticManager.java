package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {
    private static StatisticManager statisticManager;
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance(){
        if(statisticManager == null){
            statisticManager = new StatisticManager();
        }
        return statisticManager;
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }


    public Map<Date,Long> profitOfAdvertisement(){
        Map<Date,Long> salaryOfAd = new TreeMap<>();
        for(EventDataRow event : statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS)){
            VideoSelectedEventDataRow videoEvent = (VideoSelectedEventDataRow) event;
            Date date = StatisticManager.dateWithOutHours(videoEvent.getDate());
            if(!salaryOfAd.containsKey(date))
                salaryOfAd.put(date,videoEvent.getAmount());
            else {
                long amount = videoEvent.getAmount() + salaryOfAd.get(date);
                salaryOfAd.put(date,amount);
            }
        }
        return salaryOfAd;
    }

    public Map<Date,Map<String,Integer>> CookWorkloading(){
        Map<Date,Map<String,Integer>> map = new TreeMap<>();
        for(EventDataRow event : statisticStorage.getStorage().get(EventType.COOKED_ORDER)){
            CookedOrderEventDataRow cookEvent = (CookedOrderEventDataRow) event;
            Date date = StatisticManager.dateWithOutHours(cookEvent.getDate());
            if(!map.containsKey(date)) {
                map.put(date, new TreeMap<String, Integer>());
                map.get(date).put(cookEvent.getCookName(),cookEvent.getTime());
            }else{
                int totalTime = cookEvent.getTime();
                if(map.get(date).containsKey(cookEvent.getCookName())){
                    totalTime += map.get(date).get(cookEvent.getCookName());
                    map.get(date).put(cookEvent.getCookName(),totalTime);
                }else{
                    map.get(date).put(cookEvent.getCookName(),totalTime);
                }
            }
        }
        return map;
    }

    private static Date dateWithOutHours(Date date){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR ,0);
        calendar.set(Calendar.MINUTE ,0);
        calendar.set(Calendar.SECOND ,0);
        calendar.set(Calendar.MILLISECOND ,0);
        Date newDate = calendar.getTime();
        return newDate;
    }

    private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage;
        private StatisticStorage(){
            storage  = new HashMap<>();
            for(EventType event : EventType.values()){
                storage.put(event, new ArrayList<EventDataRow>());
            }
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }

        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
        }
    }

}
