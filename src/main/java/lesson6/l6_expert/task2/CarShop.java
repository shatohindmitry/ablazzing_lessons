package lesson6.l6_expert.task2;

public class CarShop {
    Car car;

    public CarShop() {
        this.car = new Car();
    }

    public CarShop price(double price) {
        car.setPrice(price);
        return this;
    }

    public String toSell() {
        try {
            double price = car.getPrice();
            return "Здравствуй клиент, цена этого авто \n" +
                    price + "\n" +
                    "Хочешь купить авто?";
        } catch (CarPriceException e) {
            return "Здравствуй клиент, цена этого авто \n" +
                    e.getMessage() + "\n" +
                    "Давайте посмотрим другое авто?";
        }
    }
}
