package lesson5.l5_expert.variantWithClasses;

public class Row {
    int month;
    double incomes, outcomes ;
    String shop;
    String date;

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

    public void setMonth(int month) {
        this.month = month;
    }

    public double getIncomes() {
        return incomes;
    }

    public void setIncomes(double incomes) {
        this.incomes = incomes;
    }

    public double getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(double outcomes) {
        this.outcomes = outcomes;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public double getMargin(){
        return getIncomes() - getOutcomes();
    }
}
