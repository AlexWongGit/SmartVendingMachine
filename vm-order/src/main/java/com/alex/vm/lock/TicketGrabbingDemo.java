package com.alex.vm.lock;

import java.util.concurrent.locks.ReentrantLock;

public class TicketGrabbingDemo {

    private static int tickets = 99;
    private final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        // 非公平
        // ReentrantLock unfairLock = new ReentrantLock();
        // 公平
        // ReentrantLock fairLock = new ReentrantLock(true);
        TicketGrabbingDemo ticketGrabbingDemo = new TicketGrabbingDemo();

        for (int i = 0; i < 100; i++) {

            Thread thread = new Thread(() -> {
                ticketGrabbingDemo.ticketGrabbing();
            });

            thread.start();
        }
    }

    private void ticketGrabbing() {
        lock.lock();
        try {
            if (tickets > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tickets--;
                System.out.println(Thread.currentThread().getName() + ": 票已售出，剩余票数" + tickets);
            } else {
                System.out.println(Thread.currentThread().getName() + ": 票已售罄，剩余票数" + tickets);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
