package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш ко

        HashMap<String,Cat> map = new HashMap<>();
        map.put("васька",new Cat("васька"));
        map.put("петься",new Cat("петька"));
        map.put("сашка",new Cat("сашка"));
        map.put("сонька",new Cat("сонька"));
        map.put("дядька",new Cat("дядька"));
        map.put("васька1",new Cat("васька1"));
        map.put("васька2",new Cat("васька2"));
        map.put("васька3",new Cat("васька3"));
        map.put("васька4",new Cat("васька5"));
        map.put("васька5",new Cat("васька5"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        HashSet<Cat> cat = new HashSet<>(map.values());
        return cat;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
