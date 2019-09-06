package com.javarush.task.task14.task1408;

public abstract class Hen extends Solution.HenFactory {
   public abstract int getCountOfEggsPerMonth();
   public String getDescription(){
        return  "Я - курица.";
   }
}
