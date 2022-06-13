package lesson3.l3_easy;

public class HomeAnimals extends Animals{
    String name;

    public HomeAnimals(String typeOfAnimal, String colorAnimal, int speedAnimal, boolean predatoryAnimal, String name) {
        super(typeOfAnimal, true, colorAnimal, speedAnimal, predatoryAnimal);
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
        return "HomeAnimals{" +
                "typeOfAnimal='" + typeOfAnimal + '\'' +
                ", itHomeAnimal=" + itHomeAnimal +
                ", colorAnimal='" + colorAnimal + '\'' +
                ", speedAnimal=" + speedAnimal +
                ", predatoryAnimal=" + predatoryAnimal +
                ", name='" + name + '\'' +
                '}';
    }
}
