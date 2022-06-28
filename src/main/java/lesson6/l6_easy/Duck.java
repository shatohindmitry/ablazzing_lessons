package lesson6.l6_easy;

public class Duck implements Flying{
    private boolean isInjured;
    public Duck(boolean isInjured) {
        this.isInjured = isInjured;
    }

    public boolean getIsInjured() {
        return isInjured;
    }

    @Override
    public void fly() throws FlyException {
        if (getIsInjured()){
            throw new FlyException("Ошибка: утка ранена");
        }else {
            System.out.println("утка летит");
        }
    }
}
