package com.alex.vm.lock;

public class SimpleQueue {

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        new Thread(new Producer(queue)).start();

        new Thread(new Customer(queue)).start();
    }

}
