package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static java.util.Locale.ENGLISH;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        Calendar year1 = new GregorianCalendar();
        SimpleDateFormat format = new SimpleDateFormat("MMMM dd yyyy" , Locale.ENGLISH);
        Date now = format.parse(date);
        year1.set(Calendar.YEAR, now.getYear());
        year1.set(Calendar.MONTH,0);
        year1.set(Calendar.DAY_OF_MONTH,1);
        Date yearstart = year1.getTime();
        long time = (now.getTime() - yearstart.getTime())/(1000*60*60*24);

        if((int)time % 2 != 0){
            return true;
        } else
            return false;
    }
}
