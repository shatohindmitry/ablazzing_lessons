package lesson6.l6_easy;

public class Plane implements Flying {
    private int countPassengers;

    public Plane(int countPassengers) {
        this.countPassengers = countPassengers;
    }

    public int getCountPassengers() {
        return countPassengers;
    }

    @Override
    public void fly() throws FlyException {
        if (getCountPassengers() < 0) {
            throw new FlyException("Ошибка: пассажиров в самолете меньше 0");
        }else {
            System.out.println("самолет летит");
        }
    }
}
