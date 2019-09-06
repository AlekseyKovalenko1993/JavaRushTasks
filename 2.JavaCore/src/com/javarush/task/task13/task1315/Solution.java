package com.javarush.task.task13.task1315;

/* 
Том, Джерри и Спайк
*/

public class Solution {
    public static void main(String[] args) {

    }
    //может двигаться
    public interface Movable {
        void move();
    }

    //может быть съеден
    public interface Edible {
        void beEaten();
    }

    //может кого-нибудь съесть
    public interface Eat {
        void eat();
    }

    public class Dog implements Movable, Eat {
        @Override
        public void move() {
            System.out.println("я иду");
        }

        @Override
        public void eat() {
            System.out.println("я съел кота");
        }
    }

    public class Cat implements Movable, Eat, Edible {
        @Override
        public void eat() {
            System.out.println("я съел мышь");
        }

        @Override
        public void beEaten() {
            System.out.println("меня съела собака");
        }

        @Override
        public void move() {
            System.out.println("я пошел");
        }
    }
    public class Mouse implements Edible, Movable{
        @Override
        public void beEaten() {
            System.out.println("меня съел котяра");
        }

        @Override
        public void move() {
            System.out.println("я пошел");
        }
    }
}