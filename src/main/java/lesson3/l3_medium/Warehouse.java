package lesson3.l3_medium;

public class Warehouse {
    private int countBottles;
    private String name;

    public Warehouse(String name, int countBottles) {
        this.name = name;
        this.countBottles = countBottles;
    }

    public int getCountBottles() {
        return this.countBottles;
    }

    public void setDropedBottles() {
        this.countBottles = this.countBottles - 1;
    }

    public String getName() {
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
