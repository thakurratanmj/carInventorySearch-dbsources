package com.util;

/**
 * Created by manjtsingh on 10/3/2015.
 */
public class Pair<K,V> {
    private K key;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    private V value;
}
