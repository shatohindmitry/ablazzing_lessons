package lesson5.l5_easy.task1;

public class CarsControl {
    public static void main(String[] args) {

        //Задача №1
        //Дано: у нас есть две модели машин - жигули и toyota. Каждая из этих машин умеет: начинать движение,
        //останавливаться, включать фары. У жигули есть особенность: она ломается. У Toyota особенность: включает музыку
        //Необходимо:
        // 1.Создать абстрактный класс, который будет описывать общие действия этих машин (методы будут не абстрактные)
        // 2.Создать два класса, которые будут наследоваться от абстрактного класса, и реализовывать особенности этих машин
        // Методы должны просто печатать на экран действия машин (начал движение, включил музыку и тд.)

        Toyota toyota = new Toyota();
        Lada lada = new Lada();

        toyota.canDrive();
        toyota.canStop();
        toyota.canLighting();
        toyota.playMusic();

        lada.canDrive();
        lada.canStop();
        lada.canLighting();
        lada.crash();

    }
}
