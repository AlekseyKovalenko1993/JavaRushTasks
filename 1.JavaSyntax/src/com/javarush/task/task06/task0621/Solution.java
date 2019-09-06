package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandfatherName = reader.readLine();
        Cat grandfather = new Cat(grandfatherName,'м');

        String grandmotherName = reader.readLine();
        Cat grandmother = new Cat(grandmotherName,'ж');

        String fatherName = reader.readLine();
        Cat father = new Cat(fatherName, grandfather ,'м');

        String motherName = reader.readLine();
        Cat mother = new Cat(motherName, grandmother ,'ж');

        String sonName = reader.readLine();
        Cat son = new Cat(sonName, father , mother,'м');

        String daughterName = reader.readLine();
        Cat daughter = new Cat(daughterName, father , mother,'ж');

        System.out.println(grandfather);
        System.out.println(grandmother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(daughter);
    }

    public static class Cat {
        private String name;
        private Cat father;
        private Cat mother;
        private char sex;
        char m = 'м';
        char z = 'ж';

        Cat(String name,char sex) {
            this.name = name;
            this.sex = sex;
        }

        Cat(String name, Cat father,char sex) {
            this.name = name;
            if (father.sex == m)
                this.father = father;
            else
                this.mother = father;
            this.sex = sex;

        }

        Cat (String name,Cat father,Cat mother,char sex){
            this.name = name;
            this.father = father;
            this.mother = mother;
            this.sex = sex;
        }

        @Override
        public String toString() {
            if (father == null && mother == null)
                return "The cat's name is " + name + " , no mother" + ", no father";
            else if(father == null)
                return "The cat's name is " + name + ", mother is " + mother.name + ", no father";
            else if(mother == null)
                return "The cat's name is " + name + " , no mother" + ", father is " + father.name;
            else
                return "The cat's name is " + name + ", mother is " + mother.name + ", father is " + father.name;
        }
    }

}
