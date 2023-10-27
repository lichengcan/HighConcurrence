package com.danny.seckill.multithreadseckill.impl;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapPerformanceExample {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // 添加大量数据
        for (int i = 0; i < 100000; i++) {
            map.put("key" + i, i);
        }

        // 多个线程同时读取
        Runnable reader = () -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println(map.get("key" + i));
            }
        };

        Thread thread1 = new Thread(reader);
        Thread thread2 = new Thread(reader);

        thread1.start();
        thread2.start();
    }
}
