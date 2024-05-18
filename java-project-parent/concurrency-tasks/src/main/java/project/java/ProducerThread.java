package project.java;

import lombok.SneakyThrows;

import java.util.Queue;

public class ProducerThread extends Thread {
    private final Queue<Integer> queue;

    public ProducerThread(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    @SneakyThrows
    public void run() {
        synchronized (queue) {
            while (true) {
                if (queue.size() < 10) {
                    int value = RandomUtil.generateRandomNumber(100);
                    queue.add(value);
                    System.out.println("Producer added value: " + value + "; size=" + queue.size() + "; thread: " + Thread.currentThread().getName());
                } else {
                    System.out.println("Queue is limited");
                }
                queue.notifyAll();
                queue.wait(RandomUtil.generateRandomNumber(100));
            }
        }
    }
}
