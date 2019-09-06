package com.javarush.task.task38.task3804;

public class Fabrica {
    public  static Throwable factroryMethod(Enum some) throws Throwable{
        if (some == null)
            return  new IllegalArgumentException();
        String message = some.toString().substring(0,1) + some.toString().substring(1).toLowerCase().replaceAll("_"," ");
        if (some instanceof ApplicationExceptionMessage){
            return  new Exception(message);
        }else if(some instanceof DatabaseExceptionMessage)
            return new RuntimeException(message);
        else if(some instanceof UserExceptionMessage)
            return   new Error(message);
        else
            return  new IllegalArgumentException();
    }
}
