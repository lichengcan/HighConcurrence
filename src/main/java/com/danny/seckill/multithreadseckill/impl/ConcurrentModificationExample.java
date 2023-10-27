package com.danny.seckill.multithreadseckill.impl;

import java.util.HashMap;
import java.util.Iterator;

public class ConcurrentModificationExample {

    public static void main(String[] args) {
//        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        HashMap<String, Integer> map = new HashMap<>();

        map.put("key1", 10);
        map.put("key2", 20);

        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            if (key.equals("key2")) {
                map.remove(key); // 在遍历时删除元素
            }
        }
        System.out.println("iterator = " + iterator);
    }
}
