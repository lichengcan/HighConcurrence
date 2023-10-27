package com.danny.seckill.multithreadseckill.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeHashMapExample {

    public static void main(String[] args) {
//        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        Map<String,Integer> map = new HashMap<>();
        map.put("key1", 10);
        map.put("key2", 20);

        // 多个线程同时读取
        Runnable reader = () -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(map.get("key1"));
            }
        };

        Thread thread1 = new Thread(reader);
        Thread thread2 = new Thread(reader);

        thread1.start();
        thread2.start();
    }
}
