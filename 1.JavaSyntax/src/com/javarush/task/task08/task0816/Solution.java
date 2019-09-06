package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("Алексей",df.parse("JANUARY 1 1993"));
        map.put("Анастасия", df.parse("AUGUST 9 1993"));
        map.put("Петя",df.parse("JANUARY 1 1993"));
        map.put("МАКСИМ",df.parse("MAY 34 1990"));
        map.put("Илья",df.parse("MAY 13 1989"));
        map.put("Максон",df.parse("MAY 12 1993"));
        map.put("Валентин",df.parse("MAY 11 1999"));
        map.put("Настя",df.parse("MAY 14 1995"));
        map.put("Саша",df.parse("MAY 12 1997"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<HashMap.Entry<String ,Date>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            HashMap.Entry<String, Date> pair = iterator.next();
            int a = pair.getValue().getMonth();
            if(a>=5 && a < 8){
                iterator.remove();
            }
        }

    }

    public static void main(String[] args) {

    }
}
