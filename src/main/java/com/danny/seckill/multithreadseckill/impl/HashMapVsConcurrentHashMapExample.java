package com.danny.seckill.multithreadseckill.impl;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;

public class HashMapVsConcurrentHashMapExample {

    public static void main(String[] args) {
        // 使用HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        // 使用ConcurrentHashMap
        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("one", 1);
        concurrentHashMap.put("two", 2);
        concurrentHashMap.put("three", 3);

        // 在HashMap中进行并发修改，会抛出ConcurrentModificationException异常
        try {
            Iterator<String> iterator = hashMap.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if (key.equals("two")) {
                    hashMap.put(key, 22); // 修改HashMap中的值
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("HashMap: ConcurrentModificationException caught");
        }

        // 在ConcurrentHashMap中进行并发修改，不会抛出异常
        Iterator<String> concurrentHashMapIterator = concurrentHashMap.keySet().iterator();
        while (concurrentHashMapIterator.hasNext()) {
            String key = concurrentHashMapIterator.next();
            if (key.equals("two")) {
                concurrentHashMap.put(key, 22); // 修改ConcurrentHashMap中的值
            }
        }

        System.out.println("HashMap: " + hashMap);
        System.out.println("ConcurrentHashMap: " + concurrentHashMap);
    }
}
