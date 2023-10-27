package com.danny.seckill.multithreadseckill.impl;

import java.util.concurrent.atomic.AtomicInteger;

public class SafeHashMapExample {

    public static void main(String[] args) {
        final AtomicInteger atomicValue = new AtomicInteger(0);

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                atomicValue.incrementAndGet();
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
        System.out.println("Final value: " + atomicValue.get());
    }
}
