package units;

public enum Mass implements Unit {
    KILOGRAMA("Quilograma", "Kg", 1000.0),
    HECTOGRAMA("Hectograma", "hg", 100.0),
    DECAGRAMA("Decagrama", "dag", 10.0),
    GRAMA("Grama", "g", 1.0),
    DECOGRAMA("Decograma", "dg", 0.1),
    CENTIGRAMA("Centigrama", "cg", 0.01),
    MILIGRAMA("Miligrama", "mg", 0.001);

    private final String symbol;
    private final double factor;
    private final String name;

    Mass(String name, String symbol, double factor) {
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
        return null;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

}