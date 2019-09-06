package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код
    String name = null;
    int weight = 3;
    int age = 4;
    String address = null;
    String color = "red";

    public void initialize(String name){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.address = address;
        this.color = color;
    }
    public void initialize(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.address = address;
        this.color = color;
    }
    public void initialize(String name, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.address = address;
        this.color = color;
    }
    public void initialize(int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.address = address;
        this.color = color;
    }
    public void initialize(int weight, String color, String address) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.address = address;
        this.color = color;
    }
        public static void main(String[] args) {

    }
}
