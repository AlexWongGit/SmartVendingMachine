package com.alex.vm.lock;

public class Customer implements Runnable {


    private Queue queue;

    public Customer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(2000);
                System.out.println("消费：" + queue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
