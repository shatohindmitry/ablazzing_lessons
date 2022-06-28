package lesson6.l6_medium.task1;

public class Tree extends Plant implements Smelling {
    private boolean withCones;
    private String name;

    public Tree(String name, boolean withCones) {
        this.name = name;
        this.withCones = withCones;
    }

    @Override
    public void canSmell() {
        System.out.println("" + name + " : умеет пахнуть");
    }
}
