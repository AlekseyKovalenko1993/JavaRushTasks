package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean sex;
        private Human parents;
        private Human children;
        private int hight;

        public Human(){
        }

        public Human(String name){
            this.name = name;
        }

        public Human(String name, boolean sex){
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human parents){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.parents = parents;
        }

        public Human(String name, boolean sex, int age, Human parents, Human children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.parents = parents;
            this.children = children;
        }

        public Human(String name, boolean sex, int age, Human parents, Human children, int hight){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.parents = parents;
            this.children = children;
            this.hight = hight;
        }
        public Human(int age){
            this.age = age;
        }

        public Human(boolean sex){
            this.sex = sex;
        }

        public Human(String name, int age){
            this.name = name;
            this.age = age;
        }
    }
}
