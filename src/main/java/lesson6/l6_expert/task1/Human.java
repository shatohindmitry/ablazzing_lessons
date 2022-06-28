package lesson6.l6_expert.task1;

public class Human {
    private int age;
    private String name;
    private double weight;

    public Human() {
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }

    public static HumanBuilder builder() {
        return new HumanBuilder();
    }

    public String info() {
        return "" + name + " - возраст " + age + ", вес " + weight;
    }

    static class HumanBuilder {
        private Human human;

        public HumanBuilder() {
            this.human = new Human();
        }

        public HumanBuilder age(int age) {
            human.setAge(age);
            return this;
        }

        public HumanBuilder name(String name) {
            human.setName(name);
            return this;
        }

        public HumanBuilder weight(double weight) {
            human.setWeight(weight);
            return this;
        }

        public Human build() {
            return human;
        }
    }
}