package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    public static AtomicInteger priority = new AtomicInteger(1);
    private int i;
    {
        i = priority.getAndIncrement();
        if(priority.get() == 11)
            priority.set(1);
    }

    public MyThread() {
        this.setPriority(i);
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority(i);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.setPriority(i);
    }

    public MyThread(String name) {
        super(name);
        this.setPriority(i);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.setPriority(i);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(i);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setPriority(i);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.setPriority(i);
    }
}
