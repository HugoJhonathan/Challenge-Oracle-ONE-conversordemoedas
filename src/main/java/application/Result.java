package application;

import units.Unit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Result {
    private Unit sourceUnit;
    private Unit targetUnit;
    private BigDecimal sourceAmount;
    private BigDecimal result;

    public Result(Unit sourceUnit, Unit targetUnit, BigDecimal initialValue, BigDecimal result) {
        this.sourceUnit = sourceUnit;
        this.targetUnit = targetUnit;
        this.sourceAmount = initialValue;
        this.result = result;
    }

    public String toString() {
        return String.format("%s (%s) = %s (%s)",
                sourceUnit.getFormattedValue(String.valueOf(sourceAmount)),
                sourceUnit.getName().toLowerCase(),
                targetUnit.getFormattedValue(getResult().toPlainString()),
                targetUnit.getName().toLowerCase());
    }

    public BigDecimal getResult() {
        result = result.setScale(4, RoundingMode.HALF_UP).stripTrailingZeros();
        return result;
    }
}
