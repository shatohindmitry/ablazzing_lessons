package lesson8;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //Дан лист
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 5, 8, 8, 9);
        Random random = new Random(1);
        //Задача №1
        //Создать класс пользователей, каждый из которых будет иметь порядковый номер, и список с числами
        //С помощью stream api:
        // 1. Оставить только числа больше 4 из integers
        // 2. Убрать дубликаты чисел
        // 3. Создать пользователей на каждый элемент стрима, где каждый элемент стрима
        // является порядковым номером пользователя.
        // 4. У каждого пользователя заполнить список чисел: количество чисел в списке
        // определяется порядковым номером пользователя. Например: для пользователя с порядковым номером 5
        // генерируется пять случайных чисел используя переменную random ( в диапазоне до 10 ).
        // 5. Создать единый стрим со всеми числами из списков пользователей.
        // 6. Умножить числа на 10
        // 7. Посчитать сумму всех чисел с помощью reduce
        // 8. Вывести на экран
        // 9. В случае если integers пустой, то должно выводиться на экран "0"
        // Внимание! Все операции должны выполняться одной цепочкой integers.stream().map() ...
        // никаких переменных не должно появиться
        // Ожидаемый результат вывода на экран:
        // 1120 - из примера, 0 - при пустом листе

        AtomicInteger atomicInteger = new AtomicInteger();
        Integer result = integers.stream().filter(e -> e > 4).distinct()
                .map(e -> new User(e, Stream.generate(() -> random.nextInt(10))
                        .limit(e)
                        .collect(Collectors.toList())))
                .map(User::getIntegers)
                .flatMap(Collection::stream)
                .map(e -> e * 10)
                .reduce(0, Integer::sum);
        System.out.println(result); //1120

        //Задача №2
        // 1. Отсортировать список lists так, чтобы сначала были самые большие списки по размеру
        // 2. Вывести на экран все элементы
        // Ожидаемый результат: 3,4,5,1,2

        List<List<Integer>> lists = List.of(List.of(1, 2), List.of(3, 4, 5), List.of());

        List<Integer> collect = lists.stream()
                .sorted((o1, o2) -> {
                    if (o1.size() > o2.size())
                        return o2.size() - o1.size();
                    else
                        return 0;
                })
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(collect);

        //Задача №3
        // 1. Узнать, есть ли в lists хотя бы один список, который содержит сумму всех элементов вложенного листа
        // равную 12
        List<List<Integer>> lists2 = List.of(List.of(1, 2), List.of(3, 4, 5), List.of());

        boolean present = lists2.stream()
                .anyMatch(e -> (e.stream().reduce(0, Integer::sum)) == 12);
        System.out.println(present);

    }
}
