package com.danny.seckill.multithreadseckill.impl;

import java.util.concurrent.ConcurrentHashMap;

public class TaskScheduler {
    private ConcurrentHashMap<String, Runnable> taskMap = new ConcurrentHashMap<>();

    public void addTask(String taskName, Runnable task) {
        taskMap.put(taskName, task);
    }

    public Runnable getTask(String taskName) {
        return taskMap.get(taskName);
    }

    public void removeTask(String taskName) {
        taskMap.remove(taskName);
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        // 添加任务
        scheduler.addTask("task1", () -> System.out.println("Task 1 is running"));
        scheduler.addTask("task2", () -> System.out.println("Task 2 is running"));

        // 多线程获取和运行任务
        Runnable task1 = scheduler.getTask("task1");
        Runnable task2 = scheduler.getTask("task2");

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        // 移除任务
        scheduler.removeTask("task1");
    }
}
