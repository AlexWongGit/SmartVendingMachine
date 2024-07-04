package com.alex.vm.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Queue {

    private Object[] items;

    int size = 0;

    int takeIndex;

    int putIndex;

    private ReentrantLock lock;

    public Condition notEmpty;

    public Condition notFull;

    public Queue(int capacity) {
        items = new Object[capacity];
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    public void put(Object value) throws InterruptedException {
        lock.lock();
        try {
            while (size == items.length) {
                // 队列满了让生产者等待
                notFull.await();
            }
            items[putIndex] = value;
            if (++putIndex == items.length) {
                putIndex = 0;
            }
            size++;
            // 生产完唤醒消费者
            notEmpty.signal();
        } finally {
            lock.unlock();
            System.out.println("producer生产:" + value);
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                // 队列空了让消费者等待
                notEmpty.await();
            }
            Object value = items[takeIndex];
            items[takeIndex] = null;

            if (++takeIndex == items.length) {
                takeIndex = 0;
            }
            size--;
            // 消费完唤醒生产者
            notFull.signal();
            return value;
        }finally {
            lock.unlock();
        }
    }
}
