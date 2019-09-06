package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private Dish(int duration){
        this.duration = duration;
    }

    private int duration;

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){
        String str = new String();
        for(Dish name : Dish.values()){
            str += name.toString() + ", ";
        }
        return str.substring(0,str.length() - 2);
    }
}
