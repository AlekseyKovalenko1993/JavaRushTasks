package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human ded1 = new Human("Вася",true,78);
        Human baba1 = new Human("Дуня",false,78);
        Human ded2 = new Human("Иван",true,76);
        Human baba2 = new Human("Света",false,74);
        Human papa = new Human("Петя",true,45, ded1,baba1);
        Human mama = new Human("Валя",false,43, ded2,baba2);
        Human son1 = new Human("Игорь",true,18, papa,mama);
        Human son2 = new Human("Леша",true,15, papa,mama);
        Human son3 = new Human("Антон",true,14, papa,mama);
        System.out.println(ded1.toString());
        System.out.println(baba1.toString());
        System.out.println(ded2.toString());
        System.out.println(baba2.toString());
        System.out.println(papa.toString());
        System.out.println(mama.toString());
        System.out.println(son1.toString());
        System.out.println(son2.toString());
        System.out.println(son3.toString());
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        int age;
        Human mother;
        Human father;
        boolean sex;

        public Human(String name,boolean sex, int age){
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
        }



        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















