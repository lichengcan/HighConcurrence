package com.danny.seckill.multithreadseckill.impl;

import java.util.concurrent.ConcurrentHashMap;

public class DataConsistencyExample {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("key1", 10);

        // 多个线程同时修改
        Runnable updater = () -> {
            for (int i = 0; i < 10000; i++) {
                map.put("key1", map.get("key1") + 1);
            }
        };

        Thread thread1 = new Thread(updater);
        Thread thread2 = new Thread(updater);

        thread1.start();
        thread2.start();
    }
}
