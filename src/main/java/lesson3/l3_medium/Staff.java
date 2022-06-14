package lesson3.l3_medium;

public class Staff {
    private int dropBottle;
    private String name;

    public Staff(String name) {
        this.dropBottle = 0;
        this.name = name;
    }

    public Staff(int dropBottle, String name) {
        this.dropBottle = dropBottle;
        this.name = name;
    }

    public int getDropBottle() {
        return dropBottle;
    }

    public void setDropBottle() {
        this.dropBottle = this.dropBottle + 1;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "Staff{" +
                "dropBottle=" + dropBottle +
                ", name='" + name + '\'' +
                '}';
    }
}
