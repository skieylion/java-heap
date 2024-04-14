package project.java;

import lombok.SneakyThrows;

import java.util.ArrayDeque;
import java.util.Queue;

public class BlockingQueue {
    private final int capacity;
    private final Queue<Integer> queue;
    private int size;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new ArrayDeque<>();
        size = 0;
    }

    @SneakyThrows
    public synchronized void put(int value) {
        if (size == capacity) {
            wait();
        }
        queue.add(value);
        size++;
        notifyAll();
    }

    @SneakyThrows
    public synchronized Integer take() {
        if (size == 0) {
            wait();
        }
        var value = queue.poll();
        size--;
        notifyAll();
        return value;
    }

    public int getSize() {
        return size;
    }
}

