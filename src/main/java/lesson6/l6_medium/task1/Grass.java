package lesson6.l6_medium.task1;

public class Grass extends Plant implements Blooming {

    private String name;

    public Grass(String name) {
        this.name = name;
    }

    @Override
    public void canBloom() {
        System.out.println("" + name + " : умеет цвести");
    }
}
