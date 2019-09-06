package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        StringBuilder s = new StringBuilder();
        while (reader1.ready()){
            s.append(reader1.readLine() + " ");
        }
        String [] mass = s.toString().split("[\\s]");
        for(int i = 0; i < mass.length - 1; i++){
            String first = mass[i];
            String second = null;
            for(int j = i+1; j < mass.length; j++){
                StringBuilder b = new StringBuilder(mass[j]);
                if(first.equals(b.toString()) || first.equals(b.reverse().toString())){
                    second = mass[j];
                    break;
                }
            }
            if(!(second == null)) {
                Pair pair = new Pair(first, second);
                if(!result.contains(pair)){
                    result.add(pair);
                }
            }
        }
        for(Pair pair : result){
            System.out.println(pair.first  + " " + pair.second);
        }
        reader.close();
        reader1.close();
    }

    public static class Pair {
        String first;
        String second;

        public Pair(){

        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
