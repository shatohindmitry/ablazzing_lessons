package lesson5.l5_medium.task2;

public class FinancialRecord {
    int incomes, outcomes;

    public FinancialRecord(int incomes, int outcomes) {
        this.incomes = incomes;
        this.outcomes = outcomes;
    }

    public float getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(int outcomes) {
        this.outcomes = outcomes;
    }

    public float getIncomes() {
        return incomes;
    }

    public void setIncomes(int incomes) {
        this.incomes = incomes;
    }

    @Override
    public String toString() {
        return "" + incomes + ";" + outcomes;
    }
}
