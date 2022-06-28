package lesson6.l6_expert.task2;

public class Car {
    private double price;

    public double getPrice() throws CarPriceException {
        if (price <= 0) {
            throw new CarPriceException("Неизвестна мне");
        } else {
            return price;
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
