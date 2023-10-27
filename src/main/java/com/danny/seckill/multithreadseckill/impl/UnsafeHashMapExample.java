package com.danny.seckill.multithreadseckill.impl;

import java.util.HashMap;
import java.util.Map;

public class UnsafeHashMapExample {

    public static void main(String[] args) {
        final Map<String, Integer> map = new HashMap<>();
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                // 多个线程同时向HashMap添加元素
                String key = "key";
                synchronized (key) {
                    map.put(key, map.getOrDefault("key", 0) + 1);
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印最终结果
        System.out.println("Final value for 'key': " + map.get("key"));
    }
}
