package com.javarush.task.task08.task0814;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(11);
        set.add(24);
        set.add(32);
        set.add(56);
        set.add(25);
        set.add(65);
        set.add(1);
        set.add(5);
        set.add(3);
        set.add(2);
        set.add(88);
        set.add(55);
        set.add(44);
        set.add(26);
        set.add(7);
        set.add(6);
        set.add(8);
        set.add(17);
        set.add(15);
        set.add(13);
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            if(iterator.next() > 10)
                iterator.remove();
        }
        return set;

    }

    public static void main(String[] args) {

    }
}
