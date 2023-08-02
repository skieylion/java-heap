package project.java;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        //Пример 1. Группировка по ключу с вычислением количества
        List<String> items = Arrays.asList("apple", "banana", "apple", "apple");
        Map<String, Long> result = items.stream().collect(Collectors
                .groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
        //Пример 2. Группировка по полю класса на списки
        List<Worker> workers = Arrays.asList(new Worker("John", "developer", 100),
                new Worker("Karl", "developer", 200),
                new Worker("Simon", "designer", 300));
        Map<String, List<Worker>> workersByPosition = workers.stream().collect(Collectors
                .groupingBy(Worker::getPosition));
        System.out.println(workersByPosition.get("developer"));
        //Пример 3. Группировка может быть не только по спискам, но и других коллекциям
        Map<String, Set<Worker>> workersByPositionSet = workers.stream().collect(Collectors
                .groupingBy(Worker::getPosition, Collectors.toSet()));
        System.out.println(workersByPosition.get("developer"));
        //Пример 4. Подсчет списка рабочих на должностях (вместо списка)
        Map<String, Long> workersCounting = workers.stream().collect(Collectors
                .groupingBy(Worker::getPosition, Collectors.counting()));
        System.out.println(workersCounting);
        //Пример 5. Кроме подсчета количества работников по должностям можно вычислить и среднее значение параметра
        Map<String, Double> workersAverageSalary = workers.stream().collect(Collectors
                .groupingBy(Worker::getPosition, Collectors.averagingDouble(Worker::getSalary)));
        System.out.println(workersAverageSalary);
        //Пример 6. Группируем и соеднияем элементы в строку
        Map<String, String> workersString = workers.stream().collect(Collectors
                .groupingBy(Worker::getPosition, Collectors.mapping(Worker::getName, Collectors.joining(",", "{", "}"))));
        System.out.println(workersString);
    }
}

@AllArgsConstructor
@Getter
class Worker {
    private String name;
    private String position;
    private long salary;
}