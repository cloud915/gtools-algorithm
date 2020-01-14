package com.gtools.algorithm.biz;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @Description
 * @Author ghy
 * @Date 2020/1/14 17:56
 */
public class LRU1 {

    /*public static class Entry<K, V> {
        public K key;
        public V value;
        //public Entry<K, V> prev;
        //public Entry<K, V> next;

    }*/

    private HashMap<String, String> CACHE_MAP = new LinkedHashMap<>(100, 75, true);

    public void set(String key, String val) {
        if (!CACHE_MAP.containsKey(key)) {
            CACHE_MAP.put(key, val);
        }
    }

    public String get(String key) {
        return CACHE_MAP.get(key);
    }

    public void remove(String key) {
        CACHE_MAP.remove(key);
    }
}
