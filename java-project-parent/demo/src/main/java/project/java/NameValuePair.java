package project.java;

import java.io.Serializable;
import java.util.HashMap;

public class NameValuePair<K, V> extends TestGeneric<V> {
    private final HashMap<K, V> map = new HashMap<>();

    public void addValue(K key, V value) {
        map.put(key, value);
        System.out.println(SubNameValuePair.<Integer>zero(2, 3, 4));
        System.out.println(SubNameValuePair.<Integer>num(2, 3, 4));
    }

    public V getValue(K key) {
        return map.get(key);
    }
}

class SubNameValuePair {
    public static <T> T zero(T... t) {
        return t[0];
    }

    public static <T extends Number & Comparable & Serializable> T num(T... t) {
        return t[0];
    }

    public static <T extends Number & Comparable & Serializable> T num2(T t) {
        t.compareTo(1);
        return null;
    }
}