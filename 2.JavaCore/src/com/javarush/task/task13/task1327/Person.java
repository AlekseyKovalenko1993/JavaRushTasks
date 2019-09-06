package com.javarush.task.task13.task1327;

import java.sql.SQLOutput;

public class Person implements RepkaItem{

    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh) {
        this.name = name;
        this.namePadezh = namePadezh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePadezh() {
        return namePadezh;
    }

    public void setNamePadezh(String namePadezh) {
        this.namePadezh = namePadezh;
    }

    public  void pull(Person person2){
        System.out.println(this.name + " за " + person2);
    }

    @Override
    public String toString() {
        return this.getNamePadezh();
    }
}
