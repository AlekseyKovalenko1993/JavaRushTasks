package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Solution solution = new Solution();
        Map<String, User> usercopy = new LinkedHashMap<>();
        usercopy.putAll(users);
        solution.users = usercopy;
        return solution;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(!(obj instanceof Solution)){
            return false;
        }
        Solution solution = (Solution) obj;
        return users.equals(solution.users);
    }

    @Override
    public int hashCode() {
        return 31*users.hashCode();
    }

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            User user = new User(this.age,this.name);
            return user;
        }

        @Override
        public int hashCode() {
            return 31*(age + (name == null? 0 : name.hashCode()));
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == this)
                return true;
            if(obj == null)
                return false;
            if(!(obj instanceof User)){
                return false;
            }
            User user = (User) obj;
            if((user.age == this.age) && ((user.name == null && this.name == null) || user.name.equals(this.name)))
                return true;
            return false;
        }
    }
}
