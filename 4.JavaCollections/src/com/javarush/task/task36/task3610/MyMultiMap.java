package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        int count = 0;
        for(Entry<K,List<V>> entry : map.entrySet()){
            count += entry.getValue().size();
        }
        return count;
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        if(map.get(key) == null){
            map.put(key,new ArrayList<>(Arrays.asList(value)));
            return null;
        }
        map.get(key).add(value);
        if(map.get(key).size() > repeatCount)
            map.get(key).remove(0);
        return map.get(key).get(map.get(key).size() - 2);
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        if(map.get(key) == null)
            return null;
        if(map.get(key).size() == 1){
            V value = map.get(key).get(0);
            map.remove(key);
            return value;
        }else{
            return map.get(key).remove(0);
        }
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        ArrayList<V> list = new ArrayList<>();
        for(Map.Entry<K,List<V>> entry : map.entrySet()){
            list.addAll(entry.getValue());
        }
        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        for(Map.Entry<K,List<V>> entry : map.entrySet()){
            if(entry.getValue().contains(value))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}