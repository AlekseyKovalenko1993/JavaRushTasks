package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        String last = null;
        while (thread.getState() != State.TERMINATED) {
            if(last != thread.getState().toString()){
                System.out.println(thread.getState().toString());
                last = thread.getState().toString();
            }
        }
        if(last != State.TERMINATED.toString()){
            System.out.println(State.TERMINATED.toString());
        }
    }
}
