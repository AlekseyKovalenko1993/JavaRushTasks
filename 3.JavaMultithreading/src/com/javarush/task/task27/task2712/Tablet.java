package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    protected final int number;
    public static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> orderQueue) {
        this.queue = orderQueue;
    }

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder(){
        try {
            Order order = new Order(this);
            orderContinue(order);
            return order;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        return null;
    }

    private void orderContinue(Order order) {
        ConsoleHelper.writeMessage(order.toString());
        AdvertisementManager manager = new AdvertisementManager((order.getTotalCookingTime() * 60));
        try {
            manager.processVideos();
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        if (!order.isEmpty()) {
            queue.add(order);
        }
    }

    public void createTestOrder(){
        try {
            Order order = new TestOrder(this);
            orderContinue(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Random is unavailable.");
        }
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }
}
