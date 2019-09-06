package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException{
        writeMessage("Выбирете блюдо, для отмены введите \"exit\"");
        for(int i = 0; i < Dish.values().length; i++){
            writeMessage((i+1) + " " + Dish.values()[i].toString());
        }
        List<Dish> order = new ArrayList<>();
        while(true){
            String str = readString();
            if(str.equals("exit"))
                break;
            try{
                order.add(Dish.valueOf(str));
            }catch (IllegalArgumentException e){
                writeMessage("Такого блюда нет в меню. пробуй еще раз");
            }
        }
        return order;
    }
}
