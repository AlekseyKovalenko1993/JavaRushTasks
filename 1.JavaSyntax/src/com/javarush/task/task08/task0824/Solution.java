package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human son1 = new Human("Саша",true,15);
        Human son2 = new Human("Даник",true,5);
        Human son3 = new Human("Стас",true,12);
        Human mother = new Human("Галя",false,45,son1,son2,son3);
        Human father = new Human("Саша",true,45,son1,son2,son3);
        Human Grandma1 = new Human("Валя",false,78, mother);
        Human Grandfa1 = new Human("Петя",true,79, mother);
        Human Grandma2 = new Human("Галя",false,77,father);
        Human Grandfa2 = new Human("Петя",true,74,father);
        System.out.println(Grandfa1.toString());
        System.out.println(Grandfa2.toString());
        System.out.println(Grandma1.toString());
        System.out.println(Grandma2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(son1.toString());
        System.out.println(son2.toString());
        System.out.println(son3.toString());
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human...childs) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            ArrayList<Human> children = new ArrayList<>();
            for (Human child : childs) {
                children.add(child);
            }
            this.children = children;
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
