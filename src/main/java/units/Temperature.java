package units;

public enum Temperature implements Unit {
    CELSIUS("Celsius", "°C", 1.0, 0.0),
    FAHRENHEIT("Fahrenheit", "°F", 1.8, 32.0),
    KELVIN("Kelvin", "K", 1.0, 273.15),
    NEWTON("Newton", "°N", 0.33, 0.0),
    REAUMUR("Reaumur", "°Re", 0.8, 0.0),
    RANKINE("Rankine", "°Ra", 1.8, 491.67),
    DELISLE("Delisle", "°De", 0.666, -33.333);

    private final String name;
    private final String symbol;
    private final double factor1;
    private final double factor2;

    Temperature(String name, String symbol, double factor1, double factor2) {
        this.name = name;
        this.symbol = symbol;
        this.factor1 = factor1;
        this.factor2 = factor2;
    }

    @Override
    public double getFactor() {
        return factor1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Unit[] getAllUnits() {
        return Temperature.values();
    }

    public double getFactor2() {
        return factor2;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public double convert(double amount, Unit targetUnit) {
        checkIfTheClassesAreEquals(targetUnit);
        Temperature source = this;

        double sourceFactor1 = source.getFactor();
        double sourceFactor2 = source.getFactor2();
        double targetFactor1 = targetUnit.getFactor();
        double targetFactor2 = ((Temperature) targetUnit).getFactor2();

        if (source == DELISLE || targetUnit == DELISLE) {
            if (targetUnit == CELSIUS) {
                return 100 - (amount * 0.66666666666);
            } else if (source == CELSIUS) {
                return (100 - amount) * 1.5;
            } else {
                double convertedToCelsius = source.convert(amount, CELSIUS);
                return CELSIUS.convert(convertedToCelsius, targetUnit);
            }
        }

        double result = (amount - sourceFactor2) / sourceFactor1;
        return (result * targetFactor1 + targetFactor2);
    }

}