package com.javarush.task.task36.task3602;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class[] clazzs = Collections.class.getDeclaredClasses();
        for(Class clazz : clazzs){
            if(Modifier.isPrivate(clazz.getModifiers()) && Modifier.isPrivate(clazz.getModifiers())){
                try {
                    Method method = clazz.getDeclaredMethod("get", int.class);
                    //method.setAccessible(true);
                    //Constructor constructor = clazz.getDeclaredConstructor();
                    //constructor.setAccessible(true);
                    //method.invoke(constructor.newInstance(),0);
                    ArrayList<Class> list = new ArrayList<>(Arrays.asList(method.getExceptionTypes()));
                    if(list.contains(IndexOutOfBoundsException.class))
                        return clazz;
                }catch (NoSuchMethodException e){

                }
            }
        }
        return Collections.emptyList().getClass();
    }
}
