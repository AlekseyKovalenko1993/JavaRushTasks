package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> listTablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> listTablets, int interval) {
        this.listTablets = listTablets;
        this.interval = interval;
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Tablet tablet = listTablets.get((int) (Math.random() * listTablets.size()));
            tablet.createTestOrder();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

