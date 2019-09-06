package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if(!(n instanceof Solution)){
            return false;
        }
        if(n == this)
            return true;
        if(n.getClass() != this.getClass()){
            return false;
        }
        Solution m = (Solution) n;
        return (((m.first == null && first == null) || m.first.equals(first)) && ((m.last == null && last == null) || m.last.equals(last)));
    }

    public int hashCode() {
        return 31 * ((first == null? 0: first.hashCode()) + (last == null? 0 : last.hashCode()));
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
