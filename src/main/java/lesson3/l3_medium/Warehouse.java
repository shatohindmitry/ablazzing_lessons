package lesson3.l3_medium;

public class Warehouse {
    static private int countBottles;
    private String name;

    public Warehouse(String name, int countBottles) {
        this.name = name;
        this.countBottles = countBottles;
    }

    private static int getCountBottles() {
        return countBottles;
    }

    public static void setDropedBottles() {
        countBottles = countBottles - 1;
    }

    private String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "countBottles=" + getCountBottles() +
                ", name='" + getName() + '\'' +
                '}';
    }
}
