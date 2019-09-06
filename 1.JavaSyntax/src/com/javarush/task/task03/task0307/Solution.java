package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Zerg zerg1 = new Zerg();
        zerg1.name="sasha";
        Zerg zerg2 = new Zerg();
        zerg2.name="sasha1";
        Zerg zerg3 = new Zerg();
        zerg3.name="sasha2";
        Zerg zerg4 = new Zerg();
        zerg4.name="sasha3";
        Zerg zerg5 = new Zerg();
        zerg5.name="sasha4";
        Protoss protoss1 = new Protoss();
        protoss1.name="sasha5";
        Protoss protoss2 = new Protoss();
        protoss2.name="sasha6";
        Protoss protoss3 = new Protoss();
        protoss3.name="sasha7";
        Terran terran1 = new Terran();
        terran1.name="sasha8";
        Terran terran2 = new Terran();
        terran2.name="sasha9";
        Terran terran3 = new Terran();
        terran3.name="sasha10";
        Terran terran4 = new Terran();
        terran4.name="sasha11";
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
