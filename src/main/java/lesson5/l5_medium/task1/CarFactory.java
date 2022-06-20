package lesson5.l5_medium.task1;

public class CarFactory {
    public static void main(String[] args) {
        //Заполнение массива объектами
        int carsCount = 20;
        Object[] carArray = new Object[carsCount*2];
        for (int i = 0; i < carsCount; i++) {
            carArray[i] = createToyota();
            carArray[i+carsCount] = createLada();
        }

        //Демонстрация работы методов характерных для класса
        int i =1;
        for (Object car: carArray){
            System.out.println(i++);
            if(car instanceof Toyota){
                Toyota toyota = (Toyota) car;
                toyota.playMusic();
            } else if (car instanceof Lada) {
                Lada lada = (Lada) car;
                lada.crash();
            } else {
                System.out.println("Объект не кастуется к классу Toyota или Lada");
            }
        }
    }
    public static Toyota createToyota(){
        return new Toyota();
    }

    public static Lada createLada(){
        return new Lada();
    }
}
