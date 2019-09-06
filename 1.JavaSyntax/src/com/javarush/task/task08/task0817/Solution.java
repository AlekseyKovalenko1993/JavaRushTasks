package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("Коваленко","Алексей");
        map.put("Мороз","Анастасия");
        map.put("Зайчик","Петр");
        map.put("Чих","Алексей");
        map.put("Валера","Алексей");
        map.put("Вайшук","Алексей");
        map.put("Яковлев","Алексей");
        map.put("Сидоров","Алексей");
        map.put("Петров","Алексей");
        map.put("Иванов","Александр");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        HashMap<String, String> copy1 = new HashMap<String, String>(map);
        HashMap<String, String> copy2 = new HashMap<String, String>(map);

        int temp = 0; //Создаем временную переменную
        for (Map.Entry<String, String> pair1 : copy1.entrySet()){ // Берем пару из первого мап, проходим циклом
            for (Map.Entry<String, String> pair2 : copy2.entrySet()){ // Берем пару из второго мап.
                if (pair1.getValue().equals(pair2.getValue())){ // Сверяем совпадает ли взятая n-я пара из 1-го мап со вторым
                    temp++; // Посчитали, сколько раз совпадает
                }
                if (temp > 1){ // Если совпадает более 1-го раза, значит это то, что нам надо
                    removeItemFromMapByValue(map, pair2.getValue()); // Удаляем эту пару из мап
                    temp = 0; // Обнуляем нашу временную переменную, чтобы продолжить проверять наш мап внутри вложенного цикла.
                }
            }
            temp = 0; // обнуляем еще раз, т.к. это у нас глобальная переменная. Мы могли выйти из цикла, когда temp = 1
        }

    }




    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
    }
}
