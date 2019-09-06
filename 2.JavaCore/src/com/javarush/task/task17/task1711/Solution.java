package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        //start here - начни тут
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        switch(args[0]) {
            case ("-c") : {
                synchronized (allPeople) {
                    for (int i = 2; i < args.length; i += 3) {
                        if (args[i].equals("м"))
                            allPeople.add(Person.createMale(args[i - 1], format.parse(args[i + 1])));
                        else
                            allPeople.add(Person.createFemale(args[i - 1], format.parse(args[i + 1])));
                        System.out.println(allPeople.size() - 1);
                    }
                }
            }break;
            case("-u") : {
                synchronized (allPeople) {
                    int i = 1;
                    while (i < args.length) {
                        int j = Integer.parseInt(args[i]);
                        allPeople.get(j).setBirthDate(format.parse(args[i + 3]));
                        allPeople.get(j).setName(args[i + 1]);
                        Sex sex = (args[i + 2].equals("м")) ? Sex.MALE : Sex.FEMALE;
                        allPeople.get(j).setSex(sex);
                        i += 4;
                    }
                }
            }break;
            case ("-d") : {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int j = Integer.parseInt(args[i]);
                        allPeople.get(j).setBirthDate(null);
                        allPeople.get(j).setName(null);
                        allPeople.get(j).setSex(null);
                    }
                }
            }break;
            case ("-i") : {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int j = Integer.parseInt(args[i]);
                        String sex = (allPeople.get(j).getSex().equals(Sex.MALE)) ? "м" : "ж";
                        System.out.println(allPeople.get(j).getName() + " " + sex + " " + format1.format(allPeople.get(j).getBirthDate()));
                    }
                }
            }break;
        }
    }
}
