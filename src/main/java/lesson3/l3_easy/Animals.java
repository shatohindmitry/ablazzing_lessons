package lesson3.l3_easy;

public class Animals {
    String typeOfAnimal;
    Boolean itHomeAnimal;
    String colorAnimal;
    int speedAnimal;
    boolean predatoryAnimal;

    public Animals(String typeOfAnimal, Boolean itHomeAnimal, String colorAnimal, int speedAnimal, boolean predatoryAnimal) {
        this.typeOfAnimal = typeOfAnimal;
        this.itHomeAnimal = itHomeAnimal;
        this.colorAnimal = colorAnimal;
        this.speedAnimal = speedAnimal;
        this.predatoryAnimal = predatoryAnimal;
    }

    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public void setTypeOfAnimal(String typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
    }

    public Boolean getItHomeAnimal() {
        return itHomeAnimal;
    }

    public void setItHomeAnimal(Boolean itHomeAnimal) {
        this.itHomeAnimal = itHomeAnimal;
    }

    public String getColorAnimal() {
        return colorAnimal;
    }

    public void setColorAnimal(String colorAnimal) {
        this.colorAnimal = colorAnimal;
    }

    public int getSpeedAnimal() {
        return speedAnimal;
    }

    public void setSpeedAnimal(int speedAnimal) {
        this.speedAnimal = speedAnimal;
    }

    public boolean isPredatoryAnimal() {
        return predatoryAnimal;
    }

    public void setPredatoryAnimal(boolean predatoryAnimal) {
        this.predatoryAnimal = predatoryAnimal;
    }
}
