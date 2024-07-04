package com.alex.vm.lock;

import java.util.Random;

public class Producer implements Runnable{

    private Queue queue;


    public Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            // 隔一秒轮询生产一次
            while (true) {
                Thread.sleep(1000);
                queue.put(new Random().nextInt(1000));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
