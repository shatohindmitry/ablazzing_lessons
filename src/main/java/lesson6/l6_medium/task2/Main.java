package lesson6.l6_medium.task2;

public class Main {
    public static void main(String[] args) {

        Watch garmin = new Watch("garmin", true);
        Watch rolex = new Watch("rolex", false);
        Employee worker1 = new Employee(garmin);
        Employee worker2 = new Employee(rolex);
        Shop firstShop = new Shop(worker1);
        Shop secondShop = new Shop(worker2);
        Shop[] arrShops = new Shop[]{firstShop, secondShop};
        Brand newBrand = new Brand(arrShops);

        for (Shop shop : newBrand.getShop()) {
            try {
                shop.getEmployee().getWatch().canTick();
            } catch (WatchBrokenError e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
