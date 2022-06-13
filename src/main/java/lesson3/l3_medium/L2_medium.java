package lesson3.l3_medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L2_medium {
    public static void main(String[] args) {
        // Задание №1: Написать цикл, который будет прибавлять число к result до тех пор,
        // пока не получиться больше 1_000_000.
        // Дано:

        // Вывести на экран, количество итераций, которое потребовалось, чтобы дойти до миллиона.
        // Если число отрицательное, то сразу заканчиваем цикл, ничего не выводя.
        // Внимание: число может измениться, и не должно приводить к изменению вашего кода.
        System.out.println("Задание №1");
        double increment = 0.01123;
        double result = 0;
        double resultMax = 1_000_000;
        long iterCount = 0;
        while (true) {
            if (increment < 0) {
                break;
            } else if (result >= resultMax) {
                System.out.println("Количество итераций: " + iterCount);
                break;
            }
            result = result + increment;
            iterCount++;
        }


        // Задание №2: Дан массив единиц, произвольной длины. Создать цикл, который заменяет каждый четный элемент на 0;
        // Например, дано: [1,1,1,1,1]
        // Ожидаемый результат: [0,1,0,1,0]
        // Подсказка: прочитай про операнд "%".
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Задание №2");

        int[] arr1 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int i = 0; i < arr1.length; i++) {
            if ((i % 2) == 0) {
                arr1[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr1));


        // Задание №3:
        // Дано:
//        boolean hasFuel = true;
//        boolean hasElectricsProblem = false;
//        boolean hasMotorProblem = false;
//        boolean hasTransmissionProblem = true;
//        boolean hasWheelsProblem = true;
        // В автосервис приехала сломанная машина. Механики находят неисправность следующим способом:
        // Если у машины нет бензина и ничего не сломано, то отдают машину владельцу и берут 1000 рублей за консультацию.
        // Если у машины проблема с двигателем, то чинят и берут 10 000.
        // Если у машины проблема с электрикой, то чинят и берут 5000.
        // Если у машины проблема с коробкой передач, то чинят и берут 4000.
        // Если у машины проблема с колесами, то чинят и берут 2000.
        // Если две детали сломаны, то на общий счет идет скидка 10%.
        // Если сломана коробка передач, и электрика или двигатель, то на общий счет скидка 20%.
        // Если нет бензина и что-то сломано, то за консультацию денег не берут.
        // Ситуации, что бензин есть и ничего не сломано - быть не может.
        // Ожидаемый результат: выведен на экран счет клиенту.
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Задание №3");

        boolean hasFuel = false;
        boolean hasElectricsProblem = true;
        boolean hasMotorProblem = true;
        boolean hasTransmissionProblem = true;
        boolean hasWheelsProblem = false;

        int trouble = 0;
        float order = 0;
        float discount = 1.0f;
        if (!hasFuel & (hasElectricsProblem | hasMotorProblem | hasTransmissionProblem | hasWheelsProblem)) {
            trouble++;
            System.out.println("No fuel and any troubles");
        } else if (!hasFuel & !hasElectricsProblem & !hasMotorProblem & !hasTransmissionProblem & !hasWheelsProblem) {
            //trouble++;
            order = order + 1000.0f;
            System.out.println("No fuel: 1000");
        }
        if (hasElectricsProblem) {
            trouble++;
            order = order + 5000.0f;
            System.out.println("ElectricsProblem: 5000");
        }
        if (hasMotorProblem) {
            trouble++;
            order = order + 10000.0f;
            System.out.println("MotorProblem: 10000");
        }
        if (hasTransmissionProblem) {
            trouble++;
            order = order + 4000.0f;
            System.out.println("TransmissionProblem: 4000");
        }
        if (hasWheelsProblem) {
            trouble++;
            order = order + 2000.0f;
            System.out.println("WheelsProblem: 2000");
        }

        if (hasTransmissionProblem & (hasElectricsProblem | hasMotorProblem)) {
            discount = 0.20f;
            System.out.println("Discount 20%");
        } else if (trouble > 1) {
            discount = 0.10f;
            System.out.println("Discount 10%");
        }
        order = order - order * discount;
        System.out.println("Total: " + order);


        // Задание №4:
        // Написать систему управления складскими запасами. Создать класс склад, создать класс работники
        // (написать геттеры на все аттрибуты).
        // Количество работников минимум 3.
        // Работники берут из склада товар, и портят его. Нужно написать взаимодействие через методы работников и склад:
        // Работник берет из склада товар, на складе товар уменьшается. Работник когда взял товар, выводит на экран
        // "Ура я испортил водку!" и добавляет к себе в журнал количество испорченного товара.
        // У склада есть только одна позиция - Водка.
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Задание №4");

        Warehouse warehouse = new Warehouse("Скалад1", 100);
        System.out.println(warehouse.toString());

        Staff worker1 = new Staff("Name1");
        Staff worker2 = new Staff("Name2");
        Staff worker3 = new Staff("Name3");

        worker1.setDropBottle();
        worker1.setDropBottle();
        worker1.setDropBottle();
        worker1.setDropBottle();

        worker2.setDropBottle();
        worker3.setDropBottle();

        System.out.println(warehouse.toString());
        System.out.println(worker1.toString());
    }
}
