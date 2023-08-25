package project.java;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        flatMapping();
    }

    //фильтрация и сортировка
    static void filterAndSort() {
        List<String> list = List.of("Elen", "Karl", "John", "Andrew", "Anderson", "Alex", "Alexander", "Afrodita", "Anna");
        list.stream().filter(name -> name.startsWith("A"))
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
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

    //расчет среднего
    static void averaging() {
        double averageAge = Stream.of(new Student("Вася", 10), new Student("Петя", 19),
                        new Student("Вова", 67), new Student("Майкл", 29))
                .collect(Collectors.averagingInt(Student::getAge));
        System.out.println(averageAge);
    }

    //дополнительное преобразование
    static void collectingAndThen() {
        long count = Stream.of(new Student("Вася", 10), new Student("Петя", 19),
                        new Student("Вова", 67), new Student("Майкл", 29))
                .collect(Collectors.counting());
    }

    //фильтрация
    static void filtering() {
        var collection = Stream.generate(() -> new Random().nextInt()).limit(20)
                .collect(Collectors.filtering(n -> n > 0, Collectors.toList()));
    }

    static void flatMapping() {
        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8, 9)
        );
        var collection = listOfLists.stream()
                .collect(Collectors.flatMapping(Collection::stream, Collectors.toList()));
    }

    //группировка
    static void grouping() {
        Map<Integer, List<Student>> map1 = Stream.of(new Student("Вася", 10), new Student("Петя", 19),
                        new Student("Вова", 67), new Student("Майкл", 10))
                .collect(Collectors.groupingBy(Student::getAge));
        Map<Integer, Long> map2 = Stream.of(new Student("Вася", 10), new Student("Петя", 19),
                        new Student("Вова", 67), new Student("Майкл", 10))
                .collect(Collectors.groupingBy(Student::getAge, Collectors.counting()));
        Map<Integer, Long> map3 = Stream.of(new Student("Вася", 10), new Student("Петя", 19),
                        new Student("Вова", 67), new Student("Майкл", 10))
                .collect(Collectors.groupingBy(Student::getAge, TreeMap::new, Collectors.counting()));
    }

    static void joining() {
        String symbols = Stream.of("D", "X", "F", "A").collect(Collectors.joining());
        System.out.println(symbols);
        String symbols2 = Stream.of("D", "X", "F", "A").collect(Collectors.joining("-"));
        System.out.println(symbols2);
        String symbols3 = Stream.of("D", "X", "F", "A").collect(Collectors.joining("-", "[", "]"));
        System.out.println(symbols3);
    }

}

@Getter
@AllArgsConstructor
class Student {
    String name;
    int age;
}