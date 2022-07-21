package lesson8;

import java.util.List;

public class User {
    int number;
    List<Integer> integers;

    public User(int number, List<Integer> integers) {
        this.number = number;
        this.integers = integers;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public String toString() {
        return "User{" +
                "number=" + number +
                ", integers=" + integers +
                '}';
    }
}
