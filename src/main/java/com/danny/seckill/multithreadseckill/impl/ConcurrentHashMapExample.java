package com.danny.seckill.multithreadseckill.impl;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    public static void main(String[] args) {
        // 创建一个ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // 添加元素
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 28);

        // 获取元素
        int age = map.get("Alice");
        System.out.println("Alice's age is " + age);

        // 替换元素
        map.replace("Alice", 26);

        // 遍历元素
        for (String key : map.keySet()) {
            int value = map.get(key);
            System.out.println(key + "'s age is " + value);
        }
    }
}
