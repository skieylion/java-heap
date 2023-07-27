package project.java;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        //вывод чисел в консоль
        int[] numbers = new int[]{1, 2, 3, 4, 5, 7, 8, 9, 0};
        Arrays.stream(numbers).spliterator()
                .forEachRemaining((int value) -> System.out.print(value + " "));
        System.out.println("");
        //разделение сплитератора
        Spliterator<Integer> part1 = Arrays.stream(numbers).spliterator();
        Spliterator<Integer> part2 = part1.trySplit();
        part1.forEachRemaining(v -> System.out.print(v + " "));
        part2.forEachRemaining(v -> System.out.print(v + " "));
        System.out.println("");
        //вывод строк в консоль
        List<String> strings = Arrays.asList("Duck", "Tom", "Mark", "Elen");
        strings.spliterator().forEachRemaining(System.out::println);
        //размер слитератора
        long size = strings.spliterator().estimateSize();
        System.out.println("size=" + size);
        //характеристики слитератора
        Spliterator<String> spliterator = strings.spliterator();
        System.out.println("SIZED=" + spliterator.hasCharacteristics(Spliterator.SIZED));
        System.out.println("CONCURRENT=" + spliterator.hasCharacteristics(Spliterator.CONCURRENT));
        System.out.println("DISTINCT=" + spliterator.hasCharacteristics(Spliterator.DISTINCT));
        System.out.println("IMMUTABLE=" + spliterator.hasCharacteristics(Spliterator.IMMUTABLE));
        System.out.println("NONNULL=" + spliterator.hasCharacteristics(Spliterator.NONNULL));
        System.out.println("ORDERED=" + spliterator.hasCharacteristics(Spliterator.ORDERED));
        System.out.println("SORTED=" + spliterator.hasCharacteristics(Spliterator.SORTED));
        System.out.println("SUBSIZED=" + spliterator.hasCharacteristics(Spliterator.SUBSIZED));
        //пареллельная обработка
        List<Integer> integers = Stream.generate(() -> Math.abs(new Random().nextInt() / 10))
                .limit(100000000).collect(Collectors.toList());
        var intSpliterator1 = integers.spliterator();
        var intSpliterator2 = intSpliterator1.trySplit();
        AtomicInteger atomicSum1 = new AtomicInteger(0);
        AtomicInteger atomicSum2 = new AtomicInteger(0);

        var thread1 = new Thread(() -> intSpliterator1.forEachRemaining(v -> atomicSum1.set(atomicSum1.get() + v)), "t1");
        var thread2 = new Thread(() -> intSpliterator2.forEachRemaining(v -> atomicSum2.set(atomicSum2.get() + v)), "t2");
        long start = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        long delta = System.currentTimeMillis() - start;
        System.out.println("SUM=" + (atomicSum1.get() + atomicSum2.get()));
        System.out.println("time=" + delta);
    }
}
