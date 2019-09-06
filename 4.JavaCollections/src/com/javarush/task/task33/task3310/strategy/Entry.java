package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;

public class Entry implements Serializable {
    Long key;
    String value;
    Entry next;
    int hash;

    public Entry(int hash,Long key,String value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = hash;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != getClass())
            return false;
        Entry entry = (Entry) obj;
        return entry.key.equals(key) && entry.value.equals(value);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        return 31*hash + key.hashCode() + value.hashCode();
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
