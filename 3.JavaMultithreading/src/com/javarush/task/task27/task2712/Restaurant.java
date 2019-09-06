package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    public static void main(String[] args) {
        Cook cook1 = new Cook("Misha");
        Cook cook2 = new Cook("Lesha");
        cook1.setQueue(orderQueue);
        cook2.setQueue(orderQueue);
        StatisticManager manager = StatisticManager.getInstance();
        Waiter waiter1 = new Waiter();
        cook1.addObserver(waiter1);
        cook2.addObserver(waiter1);
        Thread threadForCook1 = new Thread(cook1);
        threadForCook1.setDaemon(true);
        Thread threadForCook2 = new Thread(cook2);
        threadForCook2.setDaemon(true);
        threadForCook1.start();
        threadForCook2.start();
        List<Tablet> tablets = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Tablet tablet = new Tablet(i + 1);
            tablet.setQueue(orderQueue);
            tablets.add(tablet);
        }
        RandomOrderGeneratorTask task = new RandomOrderGeneratorTask(tablets,ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(task);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        thread.interrupt();
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
  }
