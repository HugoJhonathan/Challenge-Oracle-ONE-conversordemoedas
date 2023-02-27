package units;

public enum Length implements Unit {
    MEGA_METRO("Megametro", "Mm", 1000000.0),
    QUILOMETRO("Kilômetro", "km", 1000.0),
    HECTOMETRO("Hectômetro", "Hm", 100.0),
    DECAMETRO("Decâmetro", "dam", 10.0),
    METRO("Metro", "m", 1.0),
    DECIMETRO("Decímetro", "dm", 0.1),
    CENTIMETRO("Centímetro", "cm", 0.01),
    MILIMETRO("Milímetro", "mm", 0.001);

    private final String symbol;
    private final double factor;
    private final String name;

    Length(String name, String symbol, double factor) {
        this.name = name;
        this.symbol = symbol;
        this.factor = factor;
    }

    @Override
    public double getFactor() {
        return factor;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

}