package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    int n;
    public Plane(int n){
        this.n = n;
    }

    @Override
    public void fly() {
        System.out.println("Я сэмаль");
    }
}
