package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

public class AmigoSet<T> extends AbstractSet<T> implements Serializable,Cloneable,Set<T> {

    private static final Object PRESENT = new Object();
    private transient HashMap<T,Object> map;
    static final long serialVersionUID = 1;

    public AmigoSet(){
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends T> collection){
        map = new HashMap<>(Math.max(16,((int)(collection.size()/.75f) + 1)));
        this.addAll(collection);
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    private void readObject(ObjectInputStream in)throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        int capacity = in.readInt();
        float loadFactor = in.readFloat();
        int size = in.readInt();
        map = new HashMap<>(capacity,loadFactor);
        for(int i = 0; i < size; i++){
            map.put((T)in.readObject(),PRESENT);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        int capacity = (int)HashMapReflectionHelper.callHiddenMethod(map,"capacity");
        float loadFactor =(float)HashMapReflectionHelper.callHiddenMethod(map,"loadFactor");
        out.writeInt(capacity);
        out.writeFloat(loadFactor);
        out.writeInt(map.keySet().size());
        for(T key : map.keySet()){
            out.writeObject(key);
        }
    }


    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(T t) {
        return null == map.put(t,PRESENT);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return null == map.remove(o);
    }

    @Override
    public Object clone(){
        try {
            AmigoSet<T> newSet = new AmigoSet<>();
            newSet.map = (HashMap)map.clone();
            return newSet;
        }catch (Exception e){
            throw new InternalError();
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        AmigoSet<String> set = new AmigoSet<>();
        set.addAll(Arrays.asList("Bob","Alex","Sak"));
        ByteArrayOutputStream outBuff = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(outBuff);
        out.writeObject(set);
        ByteArrayInputStream inBuff = new ByteArrayInputStream(outBuff.toByteArray());
        ObjectInputStream in = new ObjectInputStream(inBuff);
        AmigoSet<String> newSet =(AmigoSet<String>) in.readObject();
        for(String s : set){
            System.out.println(s);
        }
        for(String s : newSet){
            System.out.println(s);
        }

    }

}

