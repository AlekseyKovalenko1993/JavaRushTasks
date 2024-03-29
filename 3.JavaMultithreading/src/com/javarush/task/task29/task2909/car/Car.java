package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public static final int MAX_TRUCK_SPEED = 80;
    public static final int MAX_SEDAN_SPEED = 120;
    public static final int MAX_CABRIOLET_SPEED = 90;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception{
            if (numberOfLiters < 0)
                throw new Exception();
            fuel += numberOfLiters;
    }

    private boolean canPassengersBeTransferred(){
        if(isDriverAvailable() && fuel > 0)
            return true;
        return false;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (isSummer(date,SummerStart,SummerEnd)) {
            consumption = getSummerConsumption(length);
        } else {
            consumption = getWinterConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if(canPassengersBeTransferred())
            return numberOfPassengers;
        return 0;
    }

    public boolean isSummer(Date date , Date summerStart, Date summerEnd){
        if(date.before(summerStart) || date.after(summerEnd))
            return false;
        else
            return true;
    }

    public double getSummerConsumption(int length){
        return length*summerFuelConsumption;
    }

    public double getWinterConsumption(int length){
        return length*winterFuelConsumption + winterWarmingUp;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public static Car create(int type, int numberOfPassengers){
        Car car = null;
        switch (type){
            case TRUCK : car = new Truck(numberOfPassengers);
            break;
            case SEDAN : car = new Sedan(numberOfPassengers);
            break;
            case CABRIOLET : car = new Cabriolet(numberOfPassengers);
            break;
        }
        return car;
    }

    abstract public int getMaxSpeed();
}