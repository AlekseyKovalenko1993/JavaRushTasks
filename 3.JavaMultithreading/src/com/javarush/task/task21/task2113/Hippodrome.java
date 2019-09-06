package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }

    public void run(){
        for(int i = 0; i < 100; i++){
            move();
            print();
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void move(){
        for(Horse horse: horses){
            horse.move();
        }
    }

    public void print(){
        for(Horse horse: horses){
            horse.print();
        }
        for(int i = 0; i < 10; i++){
            System.out.println();
        }
    }
    public Horse getWinner(){
        Horse max = horses.get(0);
        for (int i = 1; i < horses.size();i++){
            if(horses.get(i).getDistance() > max.getDistance()){
                max = horses.get(i);
            }
        }
        return max;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
       Hippodrome hippodrome = new Hippodrome(new ArrayList<>());
       hippodrome.getHorses().add(new Horse("one",3,0));
       hippodrome.getHorses().add(new Horse("two",3,0));
       hippodrome.getHorses().add(new Horse("three",3,0));
       Hippodrome.game = hippodrome;
       game.run();
       game.printWinner();
    }
}
