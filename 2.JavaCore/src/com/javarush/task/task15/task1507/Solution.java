package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(int m){
        printMatrix(m,5,"fs");
    }

    public static void printMatrix(){
        printMatrix(8);
    }

    public static void printMatrix(int m, int n){
        printMatrix(m,n,"ada");
    }
    public static void printMatrix(int m, String a){
        printMatrix(m, 5, (Object)a);
    }
    public static void printMatrix(int n, Object a){
        printMatrix(n, 4,a);
    }
    public static void printMatrix(int n, int m, String a, String b){
        printMatrix(n,m,a);
        printMatrix(n,m,b);
    }
    public static void printMatrix(String a){
        printMatrix(5,4,a);
    }
    public static void printMatrix(String a, String b){
        printMatrix(5,5,a,b);
    }
}
