package project.java;

import lombok.SneakyThrows;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    @SneakyThrows
    static List<Thread> createThreads(int countOfThreads, Queue<Integer> integers, boolean isProducer) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < countOfThreads; i++) {
            Thread thread = isProducer ? new ProducerThread(integers) : new ConsumerThread(integers);
            threads.add(thread);
            thread.start();
        }
        return threads;
    }

    @SneakyThrows
    static void join(List<Thread> threads) {
        for (var thread : threads) {
            thread.join();
        }
    }


    public static void main(String[] args) {
        System.out.println("Starting ...");
        Queue<Integer> integers = new ArrayDeque<>();
        int countOfProducers = 2;
        int countOfConsumers = 4;
        var producers = createThreads(countOfProducers, integers, true);
        var consumers = createThreads(countOfConsumers, integers, false);
        join(producers);
        join(consumers);
        System.out.println("Finish");
    }
}