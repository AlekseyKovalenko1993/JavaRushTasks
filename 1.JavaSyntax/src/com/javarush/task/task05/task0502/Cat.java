package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        if (this.strength > anotherCat.strength && this.age > anotherCat.age && this.weight > anotherCat.weight)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

    }
}
