package units;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;

public class Temperature extends Unit<Temperature> {

    private static List<Temperature> all = new LinkedList<>();
    private static NumberFormat nf = NumberFormat.getCurrencyInstance();

    public static final Temperature CELSIUS = new Temperature("Celsius", "°C", 1.0, 0.0);
    public static final Temperature FAHRENHEIT = new Temperature("Fahrenheit", "°F", 1.8, 32.0);
    public static final Temperature KELVIN = new Temperature("Kelvin", "K", 1.0, 273.15);
    public static final Temperature NEWTON = new Temperature("Newton", "°N", 0.33, 0.0);
    public static final Temperature REAUMUR = new Temperature("Reaumur", "°Re", 0.8, 0.0);
    public static final Temperature RANKINE = new Temperature("Rankine", "°Ra", 1.8, 491.67);

    private double factor2;

    private Temperature(String name, String symbol, double factor1, double factor2) {
        super(name, symbol, factor1);
        this.factor2 = factor2;
        all.add(this);
    }

    public double getFactor2() {
        return factor2;
    }

    @Override
    public BigDecimal convert(BigDecimal amount, Temperature targetUnit) {

        BigDecimal sourceFactor1 = new BigDecimal(String.valueOf(getFactor()));
        BigDecimal sourceFactor2 = new BigDecimal(String.valueOf(getFactor2()));
        BigDecimal targetFactor1 = new BigDecimal(String.valueOf(targetUnit.getFactor()));
        BigDecimal targetFactor2 = new BigDecimal(String.valueOf(targetUnit.getFactor2()));

        return amount
                .subtract(sourceFactor2)
                .divide(sourceFactor1, MathContext.DECIMAL128)
                .multiply(targetFactor1)
                .add(targetFactor2)
                .setScale(4, RoundingMode.HALF_UP)
                .stripTrailingZeros();
    }

    public static Temperature[] getAll() {
        return all.toArray(new Temperature[0]);
    }

}
