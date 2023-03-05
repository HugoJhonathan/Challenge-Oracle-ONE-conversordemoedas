package units;

import java.math.BigDecimal;
import java.math.MathContext;

public abstract class Unit<T extends Unit> {

    private String name;
    private String symbol;
    private double factor;

    public Unit(String name, String symbol, double factor) {
        this.name = name;
        this.symbol = symbol;
        this.factor = factor;
    }

    public BigDecimal convert(BigDecimal amount, T targetUnit) {
        BigDecimal sourceFactorBd = new BigDecimal(String.valueOf(getFactor()));
        BigDecimal targetFactorBd = new BigDecimal(String.valueOf(targetUnit.getFactor()));
        return amount.multiply(sourceFactorBd).divide(targetFactorBd, MathContext.DECIMAL128);
    }

    public String getFormattedValue(String value) {
        return value + " " + getSymbol();
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getFactor() {
        return factor;
    }

}