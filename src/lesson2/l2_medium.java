package lesson2;

import java.util.Arrays;

public class l2_medium {
    public static void main(String[] args) {

        //Продвинутый уровень
        //Задача №1
        //Произвести преобразование "234" в число типа int и прибавить к этому числу длину строки "some_text"
        System.out.println("Первая задача:");
        String stringWithNumbers = "234";
        String stringSomeText = "some_text";

        int numbers = Integer.parseInt(stringWithNumbers);
        int result = numbers + stringSomeText.length();

        System.out.println("Результат сложения строки \"" + stringWithNumbers + "\" плюс длина строки \"" + stringSomeText + "\" равно: " + result);
        System.out.println();

        //Задача №2
        //Посчитать (a+b)^2 = ?, при a=3, b=5
        System.out.println("Вторая задача:");
        int a = 3, b = 5;
        System.out.println("Результат вычисления (a+b)^2 = ?, при a=3, b=5 равен: " + Math.pow(a + b, 2));
        System.out.println();

        //Задача №3
        //Создать два массив чисел:
        // 1,2,5,7,10
        // 2,3,2,17,15
        // Создать массив чисел, в котором будут: все числа из этих двух массивов,
        // и результат умножения чисел с одинаковым порядковым номером
        //
        //Ожидаемый результат:
        //1,2,5,7,10,2,3,2,17,15,2,6,10,119,150
        //(первый массив - 1,2,5,7,10), (второй массив - 2,3,2,17,15),
        //(результат перемножения - (1*2), (2*3), (5*2), (7*17), (10*15)
        System.out.println("Третья задача:");
        int[] firstArray = new int[]{1, 2, 5, 7, 10};
        int[] secondArray = new int[]{2, 3, 2, 17, 15};


        if (firstArray.length >= secondArray.length) {
            int[] resultArray = new int[firstArray.length * 3];
            for (int i = 0; i < firstArray.length; i++) {
                resultArray[i] = firstArray[i];
                resultArray[i + firstArray.length] = secondArray[i];
                resultArray[i + firstArray.length * 2] = firstArray[i] * secondArray[i];
            }
            System.out.println(Arrays.toString(resultArray));
        } else {
            System.out.println("Массивы разной длины");
        }
        System.out.println();

        //Задача №4
        //В слове "Hello world!" заменить все l на r, сделать все буквы заглавными, выбрать первые 8 символов
        System.out.println("Четвертая задача:");

        String helloWorld = "Hello world!";
        System.out.println(helloWorld.replaceAll("l","r").substring(0,8).toUpperCase());
        System.out.println();
    }
}
