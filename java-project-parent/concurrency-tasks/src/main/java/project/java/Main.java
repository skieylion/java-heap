package project.java;

import lombok.SneakyThrows;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {

    private static long s = 0;

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


    public static void main(String[] args) throws InterruptedException {
        sum();
    }

    static void sum() throws InterruptedException {
        //генерируем массив случайных чисел
        int countOfNumbers = 1000000;
        int[] array = new int[countOfNumbers];
        for (int i = 0; i < countOfNumbers; i++) {
            array[i] = i;
        }
        //создаем потоки
        int countOfThreads = 4;
        List<Thread> threads = new ArrayList<>();
        int offset = array.length / countOfThreads;
        for (int i = 0; i < countOfThreads; i++) {
            int left = i * offset;
            int right = i == countOfThreads - 1 ? array.length - 1 : offset * (i + 1) - 1;
            threads.add(new Thread(() -> {
                long sum = 0;
                for (int j = left; j <= right; j++) {
                    sum += array[j];
                }
                s += sum;
            }));
        }
        //запускаем потоки
        threads.forEach(Thread::start);
        for (var t : threads) t.join();
        System.out.println(s);
    }

    static void taskProducerAndConsumer() {
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