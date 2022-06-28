package lesson6.l6_medium.task2;

public class Watch implements Ticking {
    private String watchName;
    private boolean isBroken;

    public Watch(String watchName, boolean isBroken) {
        this.watchName = watchName;
        this.isBroken = isBroken;
    }

    @Override
    public void canTick() throws WatchBrokenError {
        if (!isBroken) {
            throw new WatchBrokenError("Ошибка: Часы сломались.");
        } else {
            System.out.println("Часы тикают");
        }
    }
}
