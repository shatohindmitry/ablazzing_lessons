package lesson5.l5_easy.task3;

public class FinancialRecord {
    float incomes, outcomes;

    public FinancialRecord(float incomes, float outcomes) {
        this.incomes = incomes;
        this.outcomes = outcomes;
    }

    public float getIncomes() {
        return incomes;
    }

    public void setIncomes(float incomes) {
        this.incomes = incomes;
    }

    public float getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(float outcomes) {
        this.outcomes = outcomes;
    }

    @Override
    public String toString() {
        return "доходы = " + incomes + ", расходы " + outcomes;
    }
}
