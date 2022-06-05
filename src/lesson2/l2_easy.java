package lesson2;

import java.util.Arrays;

public class l2_easy {
    public static void main(String[] args) {

        //Базовый уровень
        //Задача №1
        //Дано (их менять нельзя)
        //String hi = "                Hello ";
        //String world = " WoRld!";
        //char newLine = '\n';
        //Создать из трех переменных единую строку,
        //Привести к правильному виду (Ниже)
        //затроить (Можно вызвать тольку одну команду System.out.print())
        //
        //Результат вывода на экран:
        //Hello world!
        //Hello world!
        //Hello world!

        String hi = "                Hello ";
        String world = " WoRld!";
        char newLine = '\n';

        String result = hi.trim() + world +newLine;
        result = result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
        System.out.println("Первая задача:");
        System.out.println(result.repeat(3));
        System.out.println("");


        //Задача №2
        //Создать переменные с ростом, весом.
        //Произвести расчет индекса массы тела (вес) / (рост * рост) используя переменные, вывести на экран
        //Пример результата вывода на экран:
        //21.0

        System.out.println("Вторая задача:");
        float weight = 100f; //кг
        float height = 1.8f; //м

        float massIndex = weight / (height * height);
        System.out.println("При весе(кг): " + weight + " и росте(м) " + height + " индекс массы равен: "+ String.format("%.2f", massIndex));
        System.out.println("");

        //Задача №3
        //Создать из массива букв a,b,c,d,e, строку,вывести на экран , поменять в массиве 4 букву по счету на h,
        //и снова создать строку, вывести на экран

        System.out.println("Третья задача:");
        char[] startArray = new char[]{'a','b','c','d','e'};
        char[] resultArray = startArray.clone();
        resultArray[3] = 'h';
        System.out.println("Исходный массив символов: " + Arrays.toString(startArray));
        System.out.println("Измененный массив символов: " + Arrays.toString(resultArray));
    }
}
