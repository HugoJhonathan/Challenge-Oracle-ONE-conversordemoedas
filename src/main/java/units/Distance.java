package units;

public enum Distance implements Unit {
    MegaMetro("Mm", 1000000.0),
    Quilometro("km", 1000.0),
    Hectometro("Hm", 100.0),
    Decametro("dam", 10.0),
    Metro("m", 1.0),
    Decimetro("dm", 0.1),
    Centimetro("cm", 0.01),
    Milimetro("mm", 0.001);

    private String symbol;
    private double factor;

    Distance(String symbol, double factor) {
        this.symbol = symbol;
        this.factor = factor;
    }

    @Override
    public double getFactor() {
        return factor;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

}