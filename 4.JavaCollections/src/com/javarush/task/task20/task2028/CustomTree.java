package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    ArrayList<Entry> list;
    int count = 1;

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return list.size() - 1;
    }

    protected CustomTree() {
        root = new Entry<String>("0");
        list = new ArrayList<Entry>();
        list.add(root);
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String s) {
        Entry<String> entry = new Entry<String>(s);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).isAvailableToAddChildren()) {
                if (list.get(i).availableToAddLeftChildren) {
                    list.get(i).availableToAddLeftChildren = false;
                    list.get(i).leftChild = entry;
                    entry.parent = list.get(i);
                    list.add(entry);
                    return true;
                } else {
                    list.get(i).availableToAddRightChildren = false;
                    list.get(i).rightChild = entry;
                    entry.parent = list.get(i);
                    list.add(entry);
                    return true;
                }
            }
        }
        return false;
    }

    public String  getParent(String value){
        for(int i = 0; i < list.size(); i ++){
            if(list.get(i).elementName.equals(value))
                return list.get(i).parent.toString();
        }
        return null;
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        boolean result = false;
        if(!(o instanceof String))
            throw new UnsupportedOperationException();
        String value = (String) o;
        ArrayList<Entry> removeList = null;
        for(Entry entry : list){
            if(entry.elementName.equals(value)){
                if(entry.parent.leftChild == entry){
                    entry.parent.leftChild = null;
                    entry.parent.availableToAddLeftChildren = true;
                }else{
                    entry.parent.rightChild = null;
                    entry.parent.availableToAddRightChildren = true;
                }
                result = true;
                removeList = addRemoveElements(entry);
                break;
            }
        }
        if(result) {
            list.removeAll(removeList);
        }
        return result;
    }

    private ArrayList<Entry> addRemoveElements(Entry entry){
        ArrayList<Entry> removeList = new ArrayList<>();
        ArrayDeque<Entry> queue = new ArrayDeque<>();
        queue.add(entry);
        while(!queue.isEmpty()){
            entry = queue.poll();
            removeList.add(entry);
            if(!entry.availableToAddLeftChildren)
                queue.offer(entry.leftChild);
            if(!entry.availableToAddRightChildren)
                queue.offer(entry.rightChild);
        }
        return removeList;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    static class Entry<T> implements Serializable{
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean  isAvailableToAddChildren(){
            return (availableToAddLeftChildren || availableToAddRightChildren);
        }

        @Override
        public String toString() {
            return elementName;
        }
    }


}
