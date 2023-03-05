package units;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;

public class Temperature extends Unit<Temperature> {

    private static List<Temperature> all = new LinkedList<>();
    private static NumberFormat nf = NumberFormat.getCurrencyInstance();

    public static Temperature CELSIUS = new Temperature("Celsius", "°C", 1.0, 0.0);
    public static Temperature FAHRENHEIT = new Temperature("Fahrenheit", "°F", 1.8, 32.0);
    public static Temperature KELVIN = new Temperature("Kelvin", "K", 1.0, 273.15);
    public static Temperature NEWTON = new Temperature("Newton", "°N", 0.33, 0.0);
    public static Temperature REAUMUR = new Temperature("Reaumur", "°Re", 0.8, 0.0);
    public static Temperature RANKINE = new Temperature("Rankine", "°Ra", 1.8, 491.67);
    public static Temperature DELISLE = new Temperature("Delisle", "°De", 0.666, -33.333);

    private double factor2;

    public Temperature(String name, String symbol, double factor1, double factor2) {
        super(name, symbol, factor1);
        this.factor2 = factor2;
        all.add(this);
    }

    public double getFactor2() {
        return factor2;
    }

    @Override
    public BigDecimal convert(BigDecimal amount, Temperature targetUnit) {
        Temperature source = this;

        BigDecimal amountBd = new BigDecimal(String.valueOf(amount));
        BigDecimal sourceFactor1 = new BigDecimal(String.valueOf(source.getFactor()));
        BigDecimal sourceFactor2 = new BigDecimal(String.valueOf(source.getFactor2()));
        BigDecimal targetFactor1 = new BigDecimal(String.valueOf(targetUnit.getFactor()));
        BigDecimal targetFactor2 = new BigDecimal(String.valueOf(((Temperature) targetUnit).getFactor2()));

        if (source == DELISLE || targetUnit == DELISLE) {
            if (targetUnit == CELSIUS) {
                return new BigDecimal("100")
                        .subtract(amount.multiply(new BigDecimal("0.66666666666")));
            } else if (source == CELSIUS) {
                return new BigDecimal("100")
                        .subtract(amount)
                        .multiply(new BigDecimal("1.5"));
            } else {
                BigDecimal convertedToCelsius = source.convert(amount, CELSIUS);
                return CELSIUS.convert(convertedToCelsius, targetUnit);
            }
        }

        BigDecimal calc1 = amountBd.subtract(sourceFactor2).divide(sourceFactor1, MathContext.DECIMAL128);
        BigDecimal calc2 = calc1.multiply(targetFactor1).add(targetFactor2);
        return calc2;
    }

    public static Temperature[] getAll() {
        return all.toArray(new Temperature[0]);
    }

}
