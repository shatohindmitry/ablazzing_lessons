package lesson6.l6_easy;

public class Main {
    public static void main(String[] args) throws FlyException {
        Duck injuredDuck = new Duck(true);
        Duck noInjuredDuck = new Duck(false);
        Plane planeWithPassengers = new Plane(10);
        Plane planeWithoutPassengers = new Plane(-1);

        Flying[] arrFlying = {injuredDuck, noInjuredDuck, planeWithPassengers, planeWithoutPassengers};

        for (Flying entry : arrFlying){
            try{
                entry.fly();
            }catch (FlyException e){
                System.out.println(e.getMessage());
            }
        }


    }
}
