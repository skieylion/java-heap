package project.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws IOException {
        createStreams();
    }

    //Способы создания потоков
    static void createStreams() throws IOException {
        //от коллекции
        Collection<Integer> list = List.of(1, 2, 3);
        Stream<Integer> stream1 = list.stream();

        //из массива
        int[] array = new int[]{1, 2, 3};
        Stream<Integer> stream2 = Arrays.stream(array).boxed();

        //из строки
        String str = "Hello";
        IntStream stream3 = str.chars();

        //из файла
        Path path = Paths.get("stream-api/src/main/resources/stream.txt");
        Stream<String> stream4 = Files.lines(path);

        //генерирование
        Stream<Integer> stream5 = Stream.generate(() -> new Random().nextInt()).limit(10);
        //stream5.forEach(System.out::println);

        //билдер
        Stream<Integer> stream6 = Stream.<Integer>builder().add(1).add(2).add(5).add(12).build();

        //метод boxed
        Stream<Integer> stream7 = IntStream.of(1, 2, 3, 4).boxed();
    }
}
