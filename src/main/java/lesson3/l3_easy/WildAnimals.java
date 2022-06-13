package lesson3.l3_easy;

public class WildAnimals extends Animals{

    String name;

    public WildAnimals(String typeOfAnimal, String colorAnimal, int speedAnimal, boolean predatoryAnimal, String name) {
        super(typeOfAnimal, false, colorAnimal, speedAnimal, predatoryAnimal);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WildAnimals{" +
                "typeOfAnimal='" + typeOfAnimal + '\'' +
                ", itHomeAnimal=" + itHomeAnimal +
                ", colorAnimal='" + colorAnimal + '\'' +
                ", speedAnimal=" + speedAnimal +
                ", predatoryAnimal=" + predatoryAnimal +
                ", name='" + name + '\'' +
                '}';
    }
}
