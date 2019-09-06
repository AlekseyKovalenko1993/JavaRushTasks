package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    public void printAdvertisementProfit(){
        Map<Date,Long> map = new TreeMap<>();
        map.putAll(StatisticManager.getInstance().profitOfAdvertisement());
        double total = 0;
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
        for(Map.Entry<Date,Long> pair : map.entrySet()){
            ConsoleHelper.writeMessage(format.format(pair.getKey()) + " - " + String.format(Locale.ENGLISH ,"%.2f",(pair.getValue()*0.01d)));
            total += (double)pair.getValue()* 0.01d;
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH ,"Total - %.2f" ,total));
    }

    public void printCookWorkloading(){
        Map<Date,Map<String,Integer>> map = new TreeMap<>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return -(o1.compareTo(o2));
            }
        });
        map.putAll(StatisticManager.getInstance().CookWorkloading());
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
        for(Map.Entry<Date,Map<String,Integer>> pair : map.entrySet()){
            ConsoleHelper.writeMessage(format.format(pair.getKey()));
            for(Map.Entry<String,Integer> pair2 : pair.getValue().entrySet()){
                ConsoleHelper.writeMessage(pair2.getKey() + " - " + (int)(pair2.getValue()/60) + " min");
            }
            ConsoleHelper.writeMessage("\n");
        }

    }

    public void printActiveVideoSet(){
        for(Advertisement advertisement : StatisticAdvertisementManager.getInstance().getActiveVideo()){
            ConsoleHelper.writeMessage(advertisement.getName() + " - " + advertisement.getHits());
        }
    }

    public void printArchivedVideoSet(){
        for(Advertisement advertisement : StatisticAdvertisementManager.getInstance().getArchivedVideo()){
            ConsoleHelper.writeMessage(advertisement.getName());
        }
    }
}
