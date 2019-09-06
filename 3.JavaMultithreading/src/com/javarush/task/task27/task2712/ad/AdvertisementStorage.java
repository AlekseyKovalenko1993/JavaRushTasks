package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static volatile AdvertisementStorage advertisementStorage;
    private final List<Advertisement> videos = new ArrayList<>();

    public List<Advertisement> list(){
        return videos;
    }

    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }

    private AdvertisementStorage(){
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60));
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));
    }

    public static synchronized AdvertisementStorage getInstance(){
        AdvertisementStorage instance = advertisementStorage;
        if(instance == null){
            synchronized (AdvertisementStorage.class){
                instance = advertisementStorage;
                if(instance == null){
                    instance = advertisementStorage = new AdvertisementStorage();
                }
            }
        }
        return instance;
    }
}
