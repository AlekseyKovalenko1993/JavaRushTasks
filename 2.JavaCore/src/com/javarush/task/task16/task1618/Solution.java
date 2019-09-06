package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        TestThread now = new TestThread();
        now.start();
        Thread.sleep(5000);
        now.interrupt();

    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread{
        @Override
        public void run() {
            Thread so = Thread.currentThread();
            int n = 1000;
            while (!so.isInterrupted()) {
                try{
                    Thread.sleep(400);
                    System.out.println(n--);
                }catch (InterruptedException e){

                }
            }
        }
    }
}