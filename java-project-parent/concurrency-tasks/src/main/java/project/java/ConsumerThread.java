package project.java;

import lombok.SneakyThrows;

import java.util.Queue;

public class ConsumerThread extends Thread {

    private final Queue<Integer> queue;

    public ConsumerThread(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    @SneakyThrows
    public void run() {
        synchronized (queue) {
            while (true) {
                if (!queue.isEmpty()) {
                    int value = queue.remove();
                    System.out.println("Consumer read value: " + value + "; size: " + queue.size() + "; thread: " + Thread.currentThread().getName());
                } else {
                    System.out.println("Queue is empty");
                }
                queue.notify();
                queue.wait(RandomUtil.generateRandomNumber(10));
            }
        }
    }
}
