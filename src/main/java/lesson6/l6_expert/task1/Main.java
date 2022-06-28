package lesson6.l6_expert.task1;

public class Main {
    public static void main(String[] args) {
        Human human = Human.builder().name("Петр").age(20).weight(80).build();
        System.out.println(human.info());
    }
}
