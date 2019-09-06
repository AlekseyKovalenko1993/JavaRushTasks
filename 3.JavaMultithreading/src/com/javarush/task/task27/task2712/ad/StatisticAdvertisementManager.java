package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager manager;
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private Comparator<Advertisement> comparator = new Comparator<Advertisement>() {
        @Override
        public int compare(Advertisement o1, Advertisement o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    };

    private StatisticAdvertisementManager(){}

    public static StatisticAdvertisementManager getInstance(){
        if(manager == null){
            return manager = new StatisticAdvertisementManager();
        }
        return manager;
    }

    public ArrayList<Advertisement> getActiveVideo(){
        ArrayList <Advertisement> list = new ArrayList<>();
        for(Advertisement advertisement : storage.list()){
            if(advertisement.getHits() > 0)
                list.add(advertisement);
        }
        Collections.sort(list,comparator);
        return list;
    }
    public ArrayList<Advertisement> getArchivedVideo(){
        ArrayList<Advertisement> list = new ArrayList<>();
        for(Advertisement advertisement : storage.list()){
            if(advertisement.getHits() == 0)
                list.add(advertisement);
        }
        Collections.sort(list,comparator);
        return list;
    }
}
