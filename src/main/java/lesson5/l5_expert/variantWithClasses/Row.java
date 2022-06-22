package lesson5.l5_expert.variantWithClasses;

public class Row {
    private int month;
    private double incomes, outcomes;
    private String shop;
    private String date;

    public Row(int month, double incomes, double outcomes, String shop, String date) {
        this.month = month;
        this.incomes = incomes;
        this.outcomes = outcomes;
        this.shop = shop;
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public String getShop() {
        return shop;
    }

    public String getDate() {
        return date;
    }

    public double getIncomes() {
        return incomes;
    }

    public double getOutcomes() {
        return outcomes;
    }

    @Override
    public String toString() {
        return "Row{" +
                "month=" + month +
                ", incomes=" + incomes +
                ", outcomes=" + outcomes +
                ", shop='" + shop + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public double getMargin() {
        return getIncomes() - getOutcomes();
    }
}
