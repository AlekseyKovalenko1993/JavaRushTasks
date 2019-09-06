package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    //напишите тут ваш код
    int top ;
    int left ;
    int width;
    int height;

    public void initialize(int top, int left, int width, int height){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }
    public void initialize(int width, int height) {
        this.top = 0;
        this.left = 0;
        this.width = width;
        this.height = height;
    }
    public void initialize(int top, int width, int height){
        this.top = top;
        this.left = 0;
        this.width = width;
        this.height = height;
    }
    public void initialize(int top){
        this.top = top;
        this.left = 0;
        this.width = 0;
        this.height = 0;
    }

        public static void main(String[] args) {

    }
}
