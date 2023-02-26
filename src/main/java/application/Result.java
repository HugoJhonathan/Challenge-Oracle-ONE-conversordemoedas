package application;

import units.Unit;

public class Result {
    private Unit sourceUnit;
    private Unit targetUnit;
    private double sourceAmount;
    private double result;

    public Result(Unit sourceUnit, Unit targetUnit, double initialValue, double result) {
        this.sourceUnit = sourceUnit;
        this.targetUnit = targetUnit;
        this.sourceAmount = initialValue;
        this.result = result;
    }

    public String toString() {
        return String.format("%s (%s) → %s (%s)",
                sourceUnit.getFormattedValue(sourceAmount),
                sourceUnit.toString(),
                targetUnit.getFormattedValue(result),
                targetUnit.toString());
    }

    public void printInConsole() {
        System.out.println(this);
    }

    public double getResult() {
        return result;
    }
}
