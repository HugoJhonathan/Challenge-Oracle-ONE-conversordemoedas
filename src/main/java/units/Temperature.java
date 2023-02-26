package units;

public enum Temperature implements Unit {
    Celsius("°C", 1.0, 0.0),
    Fahrenheit("°F", 1.8, 32.0),
    Kelvin("K", 1.0, 273.15),
    Newton("°N", 0.33, 0.0),
    Reaumur("°Re", 0.8, 0.0),
    Rankine("°Ra", 1.8, 491.67),
    Delisle("°De", 2.0 / 3.0, -100.0 / 3.0);

    private String symbol;
    private double factor1;
    private double factor2;

    Temperature(String symbol, double factor1, double factor2) {
        this.symbol = symbol;
        this.factor1 = factor1;
        this.factor2 = factor2;
    }

    @Override
    public double getFactor() {
        return factor1;
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

        if (source == Delisle || targetUnit == Delisle) {
            if (targetUnit == Celsius) {
                return 100 - (amount * 0.66666666666);
            } else if (source == Celsius) {
                return (100 - amount) * 1.5;
            } else {
                double convertedToCelsius = source.convert(amount, Celsius);
                return Celsius.convert(convertedToCelsius, targetUnit);
            }
        }

        double result = (amount - sourceFactor2) / sourceFactor1;
        return (result * targetFactor1 + targetFactor2);
    }

}