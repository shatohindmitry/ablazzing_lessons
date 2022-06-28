package lesson6.l6_expert.task2;

public class Main {
    public static void main(String[] args) {
        String answerFromCarShop = new CarShop().price(-1).toSell();
        System.out.println(answerFromCarShop);

        System.out.println();

        answerFromCarShop = new CarShop().price(5000).toSell();
        System.out.println(answerFromCarShop);
    }
}
