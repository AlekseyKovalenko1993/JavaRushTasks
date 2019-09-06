package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        //start here - начни тут
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if(args[0].equals("-c")){
            if(args[2].equals("м")) {
                allPeople.add(Person.createMale(args[1], format.parse(args[3])));
            }else
                allPeople.add(Person.createFemale(args[1],format.parse(args[3])));
            System.out.println(allPeople.size() - 1);
        }
        else if (args[0].equals("-u")){
            int i = Integer.parseInt(args[1]);
            allPeople.get(i).setBirthDate(format.parse(args[4]));
            allPeople.get(i).setName(args[2]);
            Sex sex = (args[3].equals("м")) ? Sex.MALE : Sex.FEMALE;
            allPeople.get(i).setSex(sex);

        }else if(args[0].equals("-d")){
            int i = Integer.parseInt(args[1]);
            allPeople.get(i).setBirthDate(null);
            allPeople.get(i).setName(null);
            allPeople.get(i).setSex(null);
        }else if(args[0].equals("-i")){
            int i = Integer.parseInt(args[1]);
            String sex = (allPeople.get(i).getSex().equals(Sex.MALE)) ? "м" : "ж";
            System.out.println(allPeople.get(i).getName() + " " + sex + " " + format1.format(allPeople.get(i).getBirthDate()));
        }
    }
}
