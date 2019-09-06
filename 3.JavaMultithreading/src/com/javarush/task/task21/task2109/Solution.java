package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            C c = new C(getI(),getJ(),getName());
            return c;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj)
                return true;
            if(obj == null)
                return false;
            if(!(obj instanceof C))
                return false;
            C c = (C) obj;
            return (this.getI() == c.getI() && this.getJ() == c.getJ() && (this.getName() == null? c.getName() == null : this.getName().equals(c.getName())));
        }

        @Override
        public int hashCode() {
            return 31*(getI() + getJ() + (getName() == null? 0 : getName().hashCode()));
        }
    }

    public static void main(String[] args) {

    }
}
