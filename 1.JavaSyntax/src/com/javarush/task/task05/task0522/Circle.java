package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    //напишите тут ваш код

    public Circle(double x,double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle(double x, double y){
        this(x,y,10.0);
    }

    public Circle(double radius){
        this(1.0,1.0,radius);
    }
    public Circle(){

    }

    public static void main(String[] args) {

    }
}