package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        int n = (int)(Math.random() * 10);
        for(int i = 0; i < n; i++){
            int m = (int)(Math.random() * Dish.values().length);
            dishes.add(Dish.values()[m]);
        }
    }
}
