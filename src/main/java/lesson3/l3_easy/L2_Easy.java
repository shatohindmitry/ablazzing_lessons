package lesson3.l3_easy;

public class L2_Easy {
    public static void main(String[] args) {

        // Задание №1 - Написать цикл, который выводит через пробел 100 чисел с приставкой "a".
        // Ожидаемый результат: 1а 2а 3а .. 100а
        //Примечание: последний пробел не контролируется
        //Буква "а" - по хардкоду
        int intMax = 100;
        for (int i= 1; i<=intMax; i++) {
            System.out.print(i + "a ");
        }

        // Задание №2
        // Дано:
        System.out.println();
        System.out.println("Задание №2");
        int ageChildren = 16;
        // Задача: Написать условную конструкцию, которая в зависимости от возраста ребенка, отправляет его в учебное заведение
        // если ребенку до 6 лет то в сад, если до 11 лет в младшую школу, если до 17 лет в среднюю школу, иначе в университет
        // Отправляет - имеется в виду, печатает на экран: "пошел с сад", "пошел в младшую школу" и т.д.
        // Проверьте работоспособность условий, через изменение значения переменной.

        //Примечание: Не проверки, что лет в осмысленном интервале.
        //Не проверки корректности входящих данных
        //Вывод хардкод
        if(ageChildren<=5){
            System.out.println("Пошел в сад");
        }else if (ageChildren<=10){
            System.out.println("Пошел в младшую школу");
        }else if (ageChildren<=16){
            System.out.println("Пошел в среднюю школу");
        }else{
            System.out.println("Пошел в университет");
        }

        // Задание №3
        // Дано:
        boolean chicken = false;
        boolean vegetables = false;
        boolean sour = false;
        boolean toast = false;
        boolean sausage = false;
        boolean eggs = false;
        // Задача: Повара попросили сделать салат.
        // Если у повара есть все ингредиенты для "Цезаря" (курица, овощи, соус и гренки), то лучше сделать "Цезарь".
        // Если для "Цезаря" ингредиентов не нашлось, то сделать Оливье (овощи, колбаса или курица, яйца).
        // Если и для Оливье не нашлось ингредиентов, то сделать Овощной салат (нужны только овощи).
        // Если ингредиентов нет, то повар объявляет: У меня ничего нет
        // Написать набор условий, приготовления салатов, по приоритету (от Цезаря к овощному). Либо объявить о невозможности сделать салат.
        // Ожидаемый результат: вывод на экран сделанного салата или объявление о том, что ничего нет.
        // Проверьте работоспособность условий, через изменение значения переменных.

        if (chicken & vegetables & sour & toast){
            System.out.println("Цезарь");
        }else if (vegetables & (sausage | chicken) & eggs ){
            System.out.println("Оливье");
        }else if(vegetables){
            System.out.println("Овощной");
        }else if(chicken | vegetables | sour | toast | sausage | eggs){
            System.out.println("Есть некоторые продукты. Нет рецепта");
        }else {
            System.out.println("У меня ничего нет");
        }

        // Создать два класса, которые описывают какое либо животное (имеют два атрибута).
        // Написать к ним конструктор, сеттеры, геттеры.

        HomeAnimals homeCatMurzik = new HomeAnimals("Cat", "Black", 5, true, "Murzik");
        WildAnimals zebra = new WildAnimals("zebra", "Black&white", 50, false, "");
        System.out.println(homeCatMurzik.toString());
        System.out.println(zebra.toString());
    }
}
