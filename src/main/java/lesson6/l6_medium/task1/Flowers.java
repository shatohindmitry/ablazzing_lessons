package lesson6.l6_medium.task1;

public class Flowers extends Plant implements Smelling, Blooming {

    private String name;

    public Flowers(String name) {
        this.name = name;
    }

    @Override
    public void canBloom() {
        System.out.println("" + name + " : умеет цвести");
    }

    @Override
    public void canSmell() {
        System.out.println("" + name + " : умеет пахнуть");
    }
}


